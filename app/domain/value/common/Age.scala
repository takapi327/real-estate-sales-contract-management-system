package domain.value.common

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
