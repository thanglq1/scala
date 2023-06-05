package moteex.com
package features.users

import common.CirceJsonSupport
import features.users.UserDomain.User

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.typesafe.scalalogging.StrictLogging
import io.circe.generic.auto._
import io.circe.syntax.EncoderOps

import scala.util.{Failure, Success}

object UserRoute extends StrictLogging with CirceJsonSupport {
  private val userService = new UserService()
  private val pathPrefix = "users"

  def routes: Route = createUserRoute ~
    getUsersRoute ~
    getUserByIdRoute ~
    updateUserByIdRoute ~
    deleteUserByIdRoute

  private def createUserRoute: Route = path(pathPrefix) {
    post {
      entity(as[User]) { user =>
        logger.info(s"Create user with user:::${user.asJson}")
        complete("Create user successfully")
      }
    }
  }

  private def getUsersRoute: Route = path(pathPrefix) {
    get {
      onComplete(userService.getUsers) {
        case Failure(exception) => complete(StatusCodes.InternalServerError)
        case Success(users) => complete(users.asJson)
      }
    }
  }

  private def getUserByIdRoute: Route = path(pathPrefix / JavaUUID) { userId =>
    get {
      logger.info(s"Get user with userID::: $userId")
      onComplete(userService.getUserById(userId)) {
        case Failure(exception) => complete(StatusCodes.InternalServerError)
        case Success(user) => complete(user.asJson)
      }
    }
  }

  private def updateUserByIdRoute: Route = path(pathPrefix / JavaUUID) { userId =>
    get {
      logger.info(s"Update user with userId::: $userId")

      complete(s"Get user with ${userId} successfully")
    }
  }

  private def deleteUserByIdRoute: Route = path(pathPrefix / JavaUUID) { userId =>
    delete {
      logger.info(s"Delete user with userId::: $userId")
      complete(s"Delete user with $userId successfully")
    }
  }
}
