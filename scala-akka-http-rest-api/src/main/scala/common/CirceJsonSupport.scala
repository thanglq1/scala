package moteex.com
package common

import de.heikoseeberger.akkahttpcirce

// Akka HTTP’s marshalling and unmarshalling infrastructure makes it rather easy to seamlessly convert application-domain objects from and to JSON
// https://doc.akka.io/docs/akka-http/current/common/json-support.html
//entity(as[User]) { user =>
//  logger.info(s"Create user with user:::${user.asJson}")
//}
// entity(as[User]) need unmarshalling implicit so used de.heikoseeberger to support marshalling/unmarshalling
trait CirceJsonSupport extends akkahttpcirce.ErrorAccumulatingCirceSupport{

}
