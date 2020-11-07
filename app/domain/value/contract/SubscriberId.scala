package domain.value

import eu.timepit.refined._
import eu.timepit.refined.numeric._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype
import io.estatico.newtype.ops._

package object Contract {

  type SubscriberIdLong = Long Refined NonNegative

  @newtype case class SubscriberId(id: SubscriberIdLong)

  object SubscriberId {
    def apply(rawSubscriverId: Long): Either[String, SubscriberId] = {
      SubscriberId(rawSubscriverId)
    }
  }
}
