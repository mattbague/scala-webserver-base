package com.mattbague.swb.server

import akka.actor.ActorSystem
import colossus.core.IOSystem
import colossus.protocols.http.UrlParsing.{Root, _}
import colossus.protocols.http._
import colossus.service.Callback.Implicits._
import colossus.service.GenRequestHandler.PartialHandler
import com.mattbague.swb.server.wiring.RestServiceWiring

import scala.util.Properties.propOrNone

class Server(port: Int) {
  val restServiceWiring = new RestServiceWiring

  implicit val actorSystem: ActorSystem = ActorSystem()
  implicit val ioSystem: IOSystem = IOSystem()

  def run(): Unit = {
    HttpServer.start("my-cool-server", port) { initContext =>

      new Initializer(initContext) {
        override def onConnect: RequestHandlerFactory = { serverContext =>
          new RequestHandler(serverContext) {
            override def handle: PartialHandler[Http] = {
              case request@_ on Root => request.ok("Server is up!")
              case request@_ on Root / "hello" => restServiceWiring.helloWorldRestService.handle(request, None)
              case request@_ on Root / "hello" / name => restServiceWiring.helloNameRestService.handle(request, Some(name))
            }
          }
        }
      }
    }
  }
}

object ServerRunner extends App {
  val port = propOrNone("port").map(_.toInt).getOrElse(8080)

  val server = new Server(port = port)

  server.run()
}