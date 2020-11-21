package domain.value.common

/*
import eu.timepit.refined._
import eu.timepit.refined.numeric._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype

package object age {

  type AgeRule = Interval.OpenClosed[0, 150]
  type AgeInt  = Int Refined AgeRule

  @newtype case class Age(value: AgeInt)

  object Age {
    def apply(rawAge: Int): Either[String, Age] = {
      refineV[AgeRule](rawAge).map(Age(_))
    }
  }
}
*/
import library.model.{EntityValue, Error}

case class Age(value: Int) extends EntityValue[Int]

object Age extends Error {

  def apply(rawAge: Int): Either[String, Age] = {
    Either.cond(
      rawAge >= 1 && rawAge <= 150,
      new Age(rawAge),
      validationError[Int](rawAge)
    )
  }
}
