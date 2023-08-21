package http.router.features

import http.AverageGameDelay
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import http.GameHandler
import http.AverageGameStartDelay
import io.ktor.http.*

fun Route.meanGameStartDelay(gameHandler: GameHandler){
    get("startDelayMean") {
       val result = gameHandler.handle(AverageGameStartDelay())
        //val response = handler.query(AverageGameStartDelayQuery()) as AverageGameDelay
        call.respond(
            HttpStatusCode.OK,
            AverageGameDelay(result)
            )
    }
}
