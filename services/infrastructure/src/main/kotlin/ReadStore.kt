package infrastructure

import event.Event
import Projections
import event.EventType
import kotlinx.coroutines.*


class ReadStore(){
    var eventStore : MutableList<Event> = mutableListOf()
    val projections = Projections()
    private val scope = CoroutineScope(Dispatchers.IO)

    fun subscribeEvents(eventbus: EventBus) {
        scope.launch{
            eventbus.subscribe<Event> { event ->
                eventStore.add(event)
                map(event)
            }
        }
    }

    fun map(event: Event) {
        when (event.eventType) {
            EventType.PLAYER_REGISTERED -> projections.playerOpponents.apply(event)
            EventType.PLAYER_DEREGISTERED -> projections.playerOpponents.apply(event)
            EventType.PLAYER_LEFT -> projections.playerOpponents.apply(event)
            EventType.GAME_CREATED -> projections.gameStartDelays.apply(event)
            EventType.GAME_STARTED -> projections.gameStartDelays.apply(event)
            EventType.GAME_COMPLETED ->  projections.playerScores.apply(event)
            else-> throw Exception("problem mapping event type ${event.eventType}")
        }
    }
}
