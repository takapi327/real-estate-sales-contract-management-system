package domain.value.common

import eu.timepit.refined._
import eu.timepit.refined.string._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype

package object phone {

  type PhoneNumberRule = MatchesRegex["""[0-9]"""]
  type PhoneNumberInt  = String Refined PhoneNumberRule

  @newtype case class PhoneNumber(value: PhoneNumberInt)

  object PhoneNumber {
    def apply(rawPhoneNumber: Int): Either[String, PhoneNumber] = {
      refineV[PhoneNumberRule](rawPhoneNumber.toString).map(PhoneNumber(_))
    }
  }
}
