package moteex.com

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import com.typesafe.scalalogging.StrictLogging

object Main extends App with StrictLogging {
  // Need for create server
  implicit val system = ActorSystem(Behaviors.empty, "MainServer")
  // Need for map/recover
  implicit val ec = system.executionContext

  private val server = Http().newServerAt("localhost", 3366).bind(Routes.routes)

  server.map { _ =>
    logger.info("Successfully started server on localhost:3366")
  } recover {
    case ex: Exception => logger.info(s"Failed to start server due ${ex.getMessage}")
  }
}
