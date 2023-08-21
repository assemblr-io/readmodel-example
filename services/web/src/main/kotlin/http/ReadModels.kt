package http

import GameDuration
import PlayerPairs
import PlayerResult
import projections.OrderedPlayerPairsProjection
import projections.OrderedPlayerScoresProjection
import projections.OrderedStartDelayProjection

class AverageGameStartDelay {
        fun get(projection: OrderedStartDelayProjection): String = projection.averageDelay
}

class TopGameStartDelay  {
        fun get(projection: OrderedStartDelayProjection): MutableList<GameDuration> =
                projection.sortedGameDelays.slice(0..4).toMutableList()
}

class TopPlayerOpponents {
        fun get(projection: OrderedPlayerPairsProjection): List<PlayerPairs> =
                projection.sortedPlayerPairs.slice(0..4)
}

class TopPlayerScores{
        fun get(projection: OrderedPlayerScoresProjection): List<PlayerResult> =
                projection.sortedScores.slice(0..2)
}
