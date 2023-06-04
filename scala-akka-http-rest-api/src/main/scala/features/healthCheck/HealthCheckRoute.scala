package moteex.com
package features.healthCheck

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

object HealthCheckRoute {
  def routes: Route = path("health-check" / "ping") {
    get {
      complete("pong")
    }
  }
}
