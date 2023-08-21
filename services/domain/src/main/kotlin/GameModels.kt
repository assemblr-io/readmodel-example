import kotlinx.datetime.Instant
import kotlinx.datetime.serializers.InstantIso8601Serializer
import kotlinx.serialization.Serializable
import kotlin.time.Duration

interface GameData

@Serializable
data class GameCreated(
    val name: String,
    @Serializable(with = InstantIso8601Serializer::class)
    val createdAt: Instant,
    val minPlayers: Int,
    val maxPlayers: Int
) : GameData

@Serializable
data class GameStarted(@Serializable(with = InstantIso8601Serializer::class) val startedAt: Instant) : GameData

@Serializable
data class GameCompleted(
    @Serializable(with = InstantIso8601Serializer::class) val completedAt: Instant,
    val results: List<PlayerResult>
) : GameData

@Serializable
class GameDurationPosition(
    val name: String,
    val duration: Duration,
    val position: Int,
    val durationMilliseconds: Long
) :
    GameData

@Serializable
class GameDuration(val name: String, val delay: Duration) : GameData
