package vgw.events.lnd

import http.Server
import http.GameHandler
import infrastructure.EventBus
import infrastructure.ReadStore
import infrastructure.Repository
import Environment.dbConnectionString
import Environment.port
import java.sql.DriverManager

fun main(){
    val eventbus = EventBus()
    val readStore = ReadStore()
    val repository = Repository(DriverManager.getConnection(dbConnectionString))

    readStore.subscribeEvents(eventbus)
    repository.publishEvents(eventbus)
    Server(GameHandler(readStore), port).start()
}
