package http.router.features

import http.GameHandler
import http.TopDelayedGames
import http.TopGameStartDelay
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.gameStartDelayList(gameHandler: GameHandler){
    get("startDelays") {
        val result = gameHandler.handle(TopGameStartDelay())
        call.respond(
            HttpStatusCode.OK,
            TopDelayedGames(result).games
            )
    }
}