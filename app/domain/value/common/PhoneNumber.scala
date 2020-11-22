package domain.value.common
/*
import eu.timepit.refined._
import eu.timepit.refined.collection._
import eu.timepit.refined.string._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype

package object phone {

  type PhoneNumberRule = MatchesRegex[W.`"[0-9]+"`.T]
  type PhoneNumberInt  = String Refined PhoneNumberRule

  @newtype case class PhoneNumber(value: PhoneNumberInt)

  object PhoneNumber {
    def apply(rawPhoneNumber: String): Either[String, PhoneNumber] = {
      refineV[PhoneNumberRule](rawPhoneNumber).map(PhoneNumber(_))
    }
  }
}
*/
import library.model.{EntityValue, Error}

case class PhoneNumber(value: String) extends EntityValue[String]

object PhoneNumber extends Error {

  def apply(rawPhoneNumber: String): Either[String, PhoneNumber] = {
    Either.cond(
      rawPhoneNumber.matches("^\\d{2,4}-\\d{2,4}-\\d{4}$"),
      new PhoneNumber(rawPhoneNumber),
      validationError[String](rawPhoneNumber)
    )
  }
}
