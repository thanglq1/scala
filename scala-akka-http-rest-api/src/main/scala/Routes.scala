package moteex.com

import features.healthCheck.HealthCheckRoute
import features.users.UserRoute

import akka.http.scaladsl.server.Directives._

object Routes {
  val routes = pathPrefix("api" / "v1") {
    HealthCheckRoute.routes ~
      UserRoute.routes
  }
}
