package moteex.com
package features.users

import java.util.UUID

object UserDomain {
  case class User(id: UUID, username: String, email: String, password: String)
}
