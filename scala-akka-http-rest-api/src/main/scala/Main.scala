package moteex.com

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.StrictLogging

object Main extends App with StrictLogging {
  // Need for create server
  implicit val system = ActorSystem(Behaviors.empty, "MainServer")
  // Need for map/recover
  implicit val ec = system.executionContext

  private val config = ConfigFactory.load()
  private val host = config.getString("server.host")
  private val port = config.getInt("server.port")

  private val server = Http().newServerAt(host, port).bind(Routes.routes)

  server.map { _ =>
    logger.info(s"Successfully started server on $host:$port")
  } recover {
    case ex: Exception => logger.info(s"Failed to start server due ${ex.getMessage}")
  }
}
