package http

import GameDuration
import PlayerPairs
import PlayerResult
import kotlinx.serialization.Serializable

@Serializable
data class TopDelayedGames(val games: List<GameDuration>)

@Serializable
data class AverageGameDelay(val meanDelayDuration: String)

@Serializable
data class TopOpponents(val opponents: List<PlayerPairs>)

@Serializable
data class TopScores(val players: List<PlayerResult>)