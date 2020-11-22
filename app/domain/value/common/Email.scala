package domain.value.common

/*
import eu.timepit.refined._
import eu.timepit.refined.string._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype

package object email {

  type EmailRule   = MatchesRegex["""[\w\-._]+@[\w\-._]+\.[A-Za-z]+"""]
  type EmailString = String Refined EmailRule

  @newtype case class Email(value: EmailString)

  object Email {
    def apply(rawEmail: String): Either[String, Email] = {
      refineV[EmailRule](rawEmail).map(Email(_))
    }
  }
}
*/

import library.model.{EntityValue, Error}

case class Email(value: String) extends EntityValue[String]

object Email extends Error {

  def apply(rawEmail: String): Either[String, Email] = {
    Either.cond(
      rawEmail.matches("""[\w\-._]+@[\w\-._]+\.[A-Za-z]+"""),
      new Email(rawEmail),
      validationError[String](rawEmail)
    )
  }
}
