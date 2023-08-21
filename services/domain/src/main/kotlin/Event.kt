package event

import GameData
import java.util.*

data class Event(
    val streamType: String,
    val streamId: UUID,
    val version: Int,
    val eventType: EventType,
    val payload: String,
    val deserialisedPayload: GameData,
    val position: Int,
)

enum class EventType {
    PLAYER_REGISTERED,
    PLAYER_DEREGISTERED,
    PLAYER_LEFT,
    GAME_CREATED,
    GAME_STARTED,
    GAME_COMPLETED,
    PLAYER_RESULT
}