package http

import GameDuration
import PlayerPairs
import PlayerResult
import infrastructure.ReadStore

class GameHandler(private val events: ReadStore) {

    fun handle(averageDelay: AverageGameStartDelay): String {
        return averageDelay.get(events.projections.gameStartDelays)
    }

    fun handle(topDelays: TopGameStartDelay): MutableList<GameDuration> {
        return topDelays.get(events.projections.gameStartDelays)
    }

    fun handle(topOpponents: TopPlayerOpponents): List<PlayerPairs> {
        return topOpponents.get(events.projections.playerOpponents)
    }

    fun handle(topScores: TopPlayerScores): List<PlayerResult> {
        return topScores.get(events.projections.playerScores)
    }
}
