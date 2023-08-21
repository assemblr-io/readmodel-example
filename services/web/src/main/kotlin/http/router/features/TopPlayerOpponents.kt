package http.router.features

import http.GameHandler
import http.TopOpponents
import http.TopPlayerOpponents
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.topPlayerOpponents(gameHandler: GameHandler){
    get("leaderboards/opponents") {
        val result = gameHandler.handle(TopPlayerOpponents())
        call.respond(
            HttpStatusCode.OK,
            TopOpponents(result).opponents
            )
    }
}