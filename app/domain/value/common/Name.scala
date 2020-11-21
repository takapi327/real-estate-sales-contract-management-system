package domain.value.common
/*
import eu.timepit.refined._
import eu.timepit.refined.collection._
import eu.timepit.refined.boolean._
import eu.timepit.refined.string._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype

package object name {

  type NameRule   = MinSize[1] And MaxSize[16]
  type NameString = String Refined NameRule

  @newtype case class FirstName(value: NameString)
  object FirstName {
    def apply(rawFirstName: String): Either[String, FirstName] = {
      refineV[NameRule](rawFirstName).map(FirstName(_))
    }
  }

  @newtype case class LastName(value: NameString)
  object LastName {
    def apply(rawLastName: String): Either[String, LastName] = {
      refineV[NameRule](rawLastName).map(LastName(_))
    }
  }
}
*/
import library.model.{EntityValue, Error}

case class FirstName(value: String) extends EntityValue[String]
object FirstName extends Error {

  def apply(rawFirstName: String): Either[String, FirstName] = {
    Either.cond(
      rawFirstName.isEmpty,
      new FirstName(rawFirstName),
      validationError[String](rawFirstName)
    )
  }
}

case class LastName(value: String) extends EntityValue[String]
object LastName extends Error {

  def apply(rawLastName: String): Either[String, LastName] = {
    Either.cond(
      rawLastName.isEmpty,
      new LastName(rawLastName),
      validationError[String](rawLastName)
    )
  }
}
