
import event.Event
import event.EventType
import http.GameHandler
import io.ktor.client.plugins.contentnegotiation.*
import http.routing.configureRouting
import infrastructure.EventBus
import infrastructure.ReadStore
import infrastructure.Repository
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import kotlinx.serialization.Serializable
import plugins.configureSerialisation
import java.util.*
import io.ktor.test.dispatcher.*
import kotlinx.datetime.toInstant
import java.sql.DriverManager
import kotlin.test.Test
import kotlin.test.assertEquals
import vgw.eventstore.lnd.Environment.dbConnectionString

@Serializable
data class RequestData(val transactionId: String, val coins: String)

class RouteTests {
    val walletId1 = UUID.randomUUID()
    val readStore: ReadStore = ReadStore()
    val eventbus = EventBus()
    val repository = Repository(DriverManager.getConnection(dbConnectionString))

init{
    readStore.subscribeEvents(eventbus)
    repository.publishEvents(eventbus)
}


    var testApp : TestApplication = TestApplication {
        application {
            configureSerialisation()
            configureRouting(
                GameHandler(readStore)
            )
        }
    }
    var testClient = testApp.createClient {
        install(ContentNegotiation) {
            json()
        }
    }

    @Test
    fun `No URI`() = testSuspend {
        val response = testClient.get("")
        assertEquals(HttpStatusCode.NotFound, response.status)
    }

    @Test
    fun `Highest Point Scorers StatusCode`() = testSuspend {
        val response = testClient.get("/game/leaderboards/points")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("[{\"playerHandle\":\"Brad Thorn\",\"points\":30},{\"playerHandle\":\"John Matrix\",\"points\":20},{\"playerHandle\":\"Dutch\",\"points\":17}]", response.bodyAsText())
    }


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
}