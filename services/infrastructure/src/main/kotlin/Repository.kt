package infrastructure

import GameCompleted
import GameCreated
import GameStarted
import PlayerDeregistered
import PlayerLeft
import PlayerRegistered
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.sql.Connection
import java.util.*
import event.Event
import event.EventType

class Repository(private val connection: Connection) {
    private var events: MutableList<Event> = mutableListOf()
    companion object {
        const val GET_EVENTS="SELECT * FROM events"
    }

    fun publishEvents(eventbus: EventBus) = runBlocking{
        val statement = connection.prepareStatement(GET_EVENTS)
        val resultSet = statement.executeQuery()

        while (resultSet.next()) {
            val eventType = resultSet.getString("event_type")
            val payload = resultSet.getString("payload")
            val deserialisedPayload = when (eventType) {
                "GAME_CREATED" -> Json.decodeFromString<GameCreated>(payload)
                "PLAYER_REGISTERED" -> Json.decodeFromString<PlayerRegistered>(payload)
                "PLAYER_DEREGISTERED" -> Json.decodeFromString<PlayerDeregistered>(payload)
                "GAME_STARTED" -> Json.decodeFromString<GameStarted>(payload)
                "PLAYER_LEFT" -> Json.decodeFromString<PlayerLeft>(payload)
                "GAME_COMPLETED" -> Json.decodeFromString<GameCompleted>(payload)
                else -> {
                    throw Exception("blah exception")
                }
            }
            events.add(
                Event(
                    resultSet.getString("stream_type"),
                    UUID.fromString(resultSet.getString("stream_id")),
                    resultSet.getInt("version"),
                    EventType.valueOf(resultSet.getString("event_type")),
                    payload,
                    deserialisedPayload,
                    resultSet.getInt("position")
                )
            )
        }
        eventbus.emitEventList(events)
    }
}
