import projections.OrderedPlayerPairsProjection
import projections.OrderedPlayerScoresProjection
import projections.OrderedStartDelayProjection


class Projections() {
    var playerOpponents = OrderedPlayerPairsProjection()
    var playerScores = OrderedPlayerScoresProjection()
    var gameStartDelays = OrderedStartDelayProjection()
}
