package domain.value.common

import eu.timepit.refined._
import eu.timepit.refined.string._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype

package object email {

  type EmailRule   = MatchesRegex["""[\w\-._]+@[\w\-._]+\.[A-Za-z]+"""]
  type EmailString = String Refined EmailRule

  @newtype case class Email(value: EmailString) {
    def v = value.value
  }

  object Email {
    def apply(rawEmail: String): Either[String, Email] = {
      refineV[EmailRule](rawEmail).map(Email(_))
    }
  }
}
