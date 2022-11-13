package com.WSTest

import org.http4k.lens.Path
import org.http4k.routing.bind
import org.http4k.routing.websockets
import org.http4k.server.Jetty
import org.http4k.server.asServer
import org.http4k.websocket.Websocket
import org.http4k.websocket.WsMessage

val namePath = Path.of("name")

val ws = websockets(
    "/{name}" bind { ws: Websocket ->
        val name = namePath(ws.upgradeRequest)
        ws.send(WsMessage("hello $name"))
        ws.onMessage {
            println(ws.upgradeRequest.body.payload)
            ws.send(WsMessage("$name is responding"))
        }
        ws.onClose { println("$name is closing") }
    },
)

fun main() {
    ws.asServer(Jetty(9000)).start()

    println("Server started on 9000")
}
