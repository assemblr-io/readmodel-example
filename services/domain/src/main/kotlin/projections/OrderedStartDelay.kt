package projections


import event.Event
import GameCreated
import GameDuration
import GameDurationPosition
import GameStarted
import kotlin.time.DurationUnit
import kotlin.time.toDuration

class OrderedStartDelayProjection(){
    private var events = mutableListOf<Event>()
    var unsortedGameDelays  = mutableListOf<GameDurationPosition>()
    var sortedGameDelays = mutableListOf<GameDuration>()
    var averageDelay: String = ""

    fun apply(_event: Event) {
        events.add(_event)
        val gameCreatedEvents= events.filter{it.deserialisedPayload is GameCreated }.sortedBy { it.position }.groupBy { it.streamId }
        val gameStartEvents= events.filter{it.deserialisedPayload is GameStarted }.sortedBy { it.position }.groupBy { it.streamId }
        var gameDelays = mutableListOf<GameDurationPosition>()

        gameCreatedEvents.forEach eventsLoop@{game ->
            if(gameStartEvents.containsKey(game.key)){
                val gameCreated = game.value[0].deserialisedPayload as GameCreated
                val gameStarted = gameStartEvents[game.key]?.getOrNull(0)?.deserialisedPayload as GameStarted
                val durationMilliseconds = gameStarted.startedAt.minus(gameCreated.createdAt).inWholeMilliseconds

                gameDelays.add(
                    GameDurationPosition(
                        gameCreated.name,
                        durationMilliseconds.toDuration(DurationUnit.MILLISECONDS),
                        game.value[0].position, durationMilliseconds
                    )
                )
                }
            unsortedGameDelays = gameDelays
            sortedGameDelays = unsortedGameDelays
                    .sortedWith(compareByDescending<GameDurationPosition> { it.durationMilliseconds }
                    .thenBy {it.position})
                    .map{ GameDuration(it.name, it.duration) }
                    .toMutableList()
            }
        averageDelay = average()
    }

    private fun average(): String{
        var sumMilliseconds: Long = 0
        var count: Int = 0
        var average = ""

        if(unsortedGameDelays.isNotEmpty()) {
            unsortedGameDelays.forEach { game ->
                sumMilliseconds += game.durationMilliseconds
                count++
            }
            average = java.time.Duration.ofMillis(sumMilliseconds / count).toString()
        }
        return average
    }


}
