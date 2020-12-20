package domain.value.common

import eu.timepit.refined._
import eu.timepit.refined.numeric._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype

package object birthDate {

  type YearRule = Interval.OpenClosed[1500, 3000]
  type YearInt  = Int Refined YearRule

  @newtype case class Year(value: YearInt) {
    def v = value.value
  }

  object Year {
    def apply(rawYear: Int): Either[String, Year] = {
      refineV[YearRule](rawYear).map(Year(_))
    }
  }

  type MonthRule = Interval.OpenClosed[1, 12]
  type MonthInt  = Int Refined MonthRule

  @newtype case class Month(value: MonthInt) {
    def v = value.value
  }

  object Month {
    def apply(rawMonth: Int): Either[String, Month] = {
      refineV[MonthRule](rawMonth).map(Month(_))
    }
  }

  type DayRule = Interval.OpenClosed[1, 31]
  type DayInt  = Int Refined DayRule

  @newtype case class Day(value: DayInt) {
    def v = value.value
  }

  object Day {
    def apply(rawDay: Int): Either[String, Day] = {
      refineV[DayRule](rawDay).map(Day(_))
    }
  }
}
