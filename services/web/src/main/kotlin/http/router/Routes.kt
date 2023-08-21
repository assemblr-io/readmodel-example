package http.routing

import http.GameHandler
import http.router.features.*
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting(handler: GameHandler) {

    routing {
        route("/game"){
            gameStartDelayList(handler)
            meanGameStartDelay(handler)
            topPlayerOpponents(handler)
            topPlayerScores(handler)
        }
    }
}