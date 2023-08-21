package http

import http.routing.configureRouting
import io.ktor.server.engine.embeddedServer
import io.ktor.server.jetty.Jetty
import plugins.configureSerialisation


class Server(private val handler: GameHandler, private val port: Int = 8080) {
    fun start() {
        embeddedServer(Jetty, port,
            module = {
                configureSerialisation()
                configureRouting(handler)
            }
        ).start(wait = true)
    }
}
