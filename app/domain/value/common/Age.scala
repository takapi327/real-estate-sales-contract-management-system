package domain.value.common

import eu.timepit.refined._
import eu.timepit.refined.numeric._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype

import library.model.{EntityValue, Error}

package object age {

  type AgeRule = Interval.OpenClosed[0, 150]
  type AgeInt  = Int Refined AgeRule

  @newtype case class Age(value: AgeInt) {
    def v = value.value
  }

  object Age {
    def apply(rawAge: Int): Either[String, Age] = {
      refineV[AgeRule](rawAge).map(Age(_))
    }
  }
}
