package domain.value.common

import eu.timepit.refined._
import eu.timepit.refined.string._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype

object email {

  type EmailRule   = MatchesRegex["""[a-z0-9]+@[a-z0-9]+\.[a-z0-9]{2,}"""]
  type EmailString = String Refined EmailRule

  @newtype case class Email(value: EmailString)

  object Email {
    def apply(rawEmail: String): Either[String, Email] = {
      refineV[EmailRule](rawEmail).map(Email(_))
    }
  }
}
