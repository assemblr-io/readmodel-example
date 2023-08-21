

import event.Event
import event.EventType
import kotlinx.datetime.toInstant
import org.junit.Test
import projections.OrderedPlayerPairsProjection
import projections.OrderedStartDelayProjection
import java.util.*
import kotlin.test.assertEquals


class Projections {
    val events = arrayListOf<Event>(
        Event(
            "Game", UUID(1, 99), 1, EventType.GAME_CREATED, "",
            GameCreated(
                "Opening Stanza",
                "2018-10-21T12:00:00Z".toInstant(), 3, 5
            ), 1
        ),
        Event(
            "Game", UUID(1, 99), 2, EventType.GAME_STARTED, "",
            GameStarted(
                "2018-10-21T21:20:00Z".toInstant()
            ), 2
        ),

        Event(
            "Game", UUID(100, 199), 1, EventType.GAME_CREATED, "",
            GameCreated(
                "Sabotage",
                "2018-10-23T12:15:00Z".toInstant(), 3, 5
            ), 3
        ),
        Event(
            "Game", UUID(100, 199), 2, EventType.GAME_STARTED, "",
            GameStarted(
                "2018-10-23T14:50:00Z".toInstant()
            ), 4
        ),
        Event(
            "Game", UUID(1999, 2002), 2, EventType.PLAYER_REGISTERED, "playerHandle: Tester-1",
            PlayerRegistered("Tester-1"), 8
        ),
        Event(
            "Game", UUID(1999, 2002), 3, EventType.PLAYER_REGISTERED, "playerHandle: Tester-2",
            PlayerRegistered("Tester-2"), 2
        ),
        Event(
            "Game", UUID(1999, 2002), 4, EventType.PLAYER_REGISTERED, "playerHandle: Tester-3",
            PlayerRegistered("Tester-3"), 3
        ),
        Event(
            "Game", UUID(1999, 2002), 5, EventType.PLAYER_REGISTERED, "playerHandle: Tester-4",
            PlayerRegistered("Tester-4"), 4
        ),
        Event(
            "Game", UUID(1999, 2002), 6, EventType.PLAYER_DEREGISTERED, "playerHandle: Tester-4",
            PlayerDeregistered("Tester-4"), 5
        ),
        Event(
            "Game", UUID(1999, 2002), 7, EventType.PLAYER_REGISTERED, "playerHandle: Tester-6",
            PlayerRegistered("Tester-6"), 6
        ),
        Event(
            "Game", UUID(1999, 2002), 8, EventType.PLAYER_REGISTERED, "playerHandle: Tester-7",
            PlayerRegistered("Tester-7"), 7
        ),
        Event(
            "Game", UUID(1999, 2002), 1, EventType.PLAYER_REGISTERED, "playerHandle: Tester-8",
            PlayerRegistered("Tester-8"), 1
        ),
        Event(
            "Game", UUID(1999, 2002), 10, EventType.PLAYER_REGISTERED, "playerHandle: Tester-9",
            PlayerRegistered("Tester-9"), 9
        ),
        Event(
            "Game", UUID(1999, 2002), 11, EventType.PLAYER_DEREGISTERED, "playerHandle: Tester-8",
            PlayerDeregistered("Tester-8"), 10
        )
    )

    @Test
    fun gameCreated(){
        val games = OrderedStartDelayProjection()
        events.forEach { event ->
            games.apply(event)
        }
        assertEquals("9h 20m", games.sortedGameDelays[0].delay.toString())
    }

    @Test
    fun gameAverage(){
        val games = OrderedStartDelayProjection()
        events.forEach { event ->
            games.apply(event)
        }

        assertEquals("PT5H57M30S", games.averageDelay)
    }

    @Test
    fun playerPairs(){
        val games = OrderedPlayerPairsProjection()
        events.forEach { event ->
            games.apply(event)
        }
        assertEquals("Tester-2", games.sortedPlayerPairs[0].playerHandle1)
    }

}