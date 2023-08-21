package projections

import event.Event
import PlayerDeregistered
import PlayerPairs
import PlayerPairsPosition
import PlayerRegistered

class OrderedPlayerPairsProjection(){
    private var events = mutableListOf<Event>()
    var sortedPlayerPairs = mutableListOf<PlayerPairs>()

    fun apply(_event: Event) {
        events.add(_event)
        val games = events.filter{it.deserialisedPayload is PlayerRegistered ||
                it.deserialisedPayload is PlayerDeregistered
        }.sortedBy { it.position }.groupBy { it.streamId }
        var playerPairs: MutableMap<String, PlayerPairsPosition> = mutableMapOf()

        for (game in games) {
            val players = game.value.toMutableList()
            players
                .filter { it.deserialisedPayload is PlayerDeregistered }
                .forEach{deregisteredPlayer->players
                .removeAll{it.payload==deregisteredPlayer.payload}}

            players.forEachIndexed{index, player->
                val player1 = player.deserialisedPayload as PlayerRegistered

                for (otherPlayer in index + 1 until players.size){
                    val player2 = players[otherPlayer].deserialisedPayload as PlayerRegistered
                    val pair = "${player1.playerHandle}${player2.playerHandle}"
                    val reversePair = "${player2.playerHandle}${player1.playerHandle}"
                    if(playerPairs.containsKey(pair) ){
                        playerPairs[pair]!!.playerPair.matches++
                        playerPairs[pair]!!.position = player.position
                    } else if(playerPairs.containsKey(reversePair)){
                        playerPairs[reversePair]!!.playerPair.matches++
                        playerPairs[reversePair]!!.position = player.position
                    }
                    else {
                        playerPairs[pair] =
                            PlayerPairsPosition(
                                PlayerPairs(player1.playerHandle, player2.playerHandle, 1),
                                player.position
                            )
                    }
                }
            }
        }
        sortedPlayerPairs = playerPairs
            .toList()
            .sortedWith(compareByDescending<Pair<String, PlayerPairsPosition>> { it.second.playerPair.matches }
            .thenBy{ it.second.position})
            .map{it.second.playerPair}.toMutableList()
    }
}
