import kotlinx.serialization.Serializable

@Serializable
data class PlayerResult(val playerHandle: String, var points: Int) : GameData

@Serializable
data class PlayerResultPosition(val playerResult: PlayerResult, val position: Int) : GameData

@Serializable
data class PlayerRegistered(val playerHandle: String) : GameData

@Serializable
data class PlayerDeregistered(val playerHandle: String) : GameData

@Serializable
data class PlayerLeft(val playerHandle: String) : GameData

@Serializable
data class PlayerPairs(val playerHandle1: String, val playerHandle2: String, var matches: Int) : GameData

@Serializable
data class PlayerPairsPosition(val playerPair: PlayerPairs, var position: Int) : GameData
