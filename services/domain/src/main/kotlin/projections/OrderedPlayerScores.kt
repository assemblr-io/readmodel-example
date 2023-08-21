package projections

import event.Event
import GameCompleted
import PlayerResult
import PlayerResultPosition

class OrderedPlayerScoresProjection(){
    private var events = mutableListOf<Event>()
    var sortedScores = listOf<PlayerResult>()

    fun apply(_event: Event) {
        events.add(_event)
        val scores = mutableMapOf<String, PlayerResultPosition>()
        val completedGames = events.sortedBy { it.position }.groupBy { it.streamId }

        completedGames.forEach { game ->
            val gamePayload = game.value[0].deserialisedPayload as GameCompleted
            val results = gamePayload.results
            results.forEach { player ->
                if (scores[player.playerHandle] == null) {
                    scores[player.playerHandle] = PlayerResultPosition(player, game.value[0].position)
                } else {
                    scores[player.playerHandle] = PlayerResultPosition(
                        PlayerResult(
                            player.playerHandle,
                            scores[player.playerHandle]!!.playerResult.points + player.points
                        ),
                        game.value[0].position
                    )
                }
            }
        }
        sortedScores = scores
            .toList()
            .sortedWith(compareByDescending<Pair<String, PlayerResultPosition>> { it.second.playerResult.points }
            .thenBy { it.second.position })
            .map{it.second.playerResult}
    }
}

