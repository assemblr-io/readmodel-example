package http.router.features

import http.GameHandler
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import http.TopPlayerScores
import http.TopScores
import io.ktor.http.*

fun Route.topPlayerScores(gameHandler: GameHandler){
    get("leaderboards/points") {
        val result = gameHandler.handle(TopPlayerScores())
        call.respond(
            HttpStatusCode.OK,
            TopScores(result).players
            )
    }
}