
import kotlinx.datetime.toInstant
import org.junit.Test
import kotlin.test.assertIs
import kotlin.time.DurationUnit
import kotlin.time.toDuration

class GameModels {

    @Test
    fun gameCreated(){
        val game = GameCreated(
            "test",
            "2018-10-21T21:14:06Z".toInstant(),
            5,
            10
        )
        assertIs<GameCreated>(game)
    }

    @Test
    fun gameStarted(){
        val gameStarted = GameStarted("2018-10-21T21:14:06Z".toInstant())
        assertIs<GameStarted>(gameStarted)
    }

    @Test
    fun gameComplete(){
        val gameCompleted = GameCompleted("2018-10-21T21:14:06Z".toInstant(), listOf())
        assertIs<GameCompleted>(gameCompleted)
    }

    @Test
    fun gameDurationPosition(){
        val gameDurationPosition = GameDurationPosition(
            "test",
            (100000).toDuration(DurationUnit.MILLISECONDS),
            1,
            100000
        )
        assertIs<GameDurationPosition>(gameDurationPosition)
    }

    @Test
    fun gameDuration(){
        val gameDuration = GameDuration(
            "test",
            (100000).toDuration(DurationUnit.MILLISECONDS)
        )
        assertIs<GameDuration>(gameDuration)
    }

}