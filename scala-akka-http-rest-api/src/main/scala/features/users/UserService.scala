package moteex.com
package features.users

import features.users.UserDomain._

import com.typesafe.scalalogging.StrictLogging

import java.util.UUID
import scala.concurrent.Future

class UserService extends StrictLogging {
  val users = List(
    User(id = UUID.fromString("28742a42-1850-2340-8ceb-5c9ffd5bf056"), username = "thanglq", email = "thanglq@gmail.com", password = "abc!23456"),
    User(id = UUID.fromString("42872a42-1960-4230-9cef-6c9eed5bf056"), username = "thanglq1", email = "thanglq1@gmail.com", password = "abc!23456")
  )

  def getUsers: Future[List[User]] = {
    Future.successful(users)
  }

  def getUserById(userId: UUID): Future[Option[User]] = {
    val user = users.find(user => user.id == userId)
    Future.successful(user)
  }
}
