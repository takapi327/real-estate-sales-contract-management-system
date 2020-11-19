package domain.value.common

import java.time.LocalDateTime

import eu.timepit.refined._
import eu.timepit.refined.collection._
import eu.timepit.refined.boolean._
import eu.timepit.refined.string._
import eu.timepit.refined.numeric._
import eu.timepit.refined.types._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype

package object datetime {

  type YearRule = Interval.Closed[1, 3000]
  type YearInt  = Int Refined YearRule

  @newtype case class Year(value: YearInt) {
    def toInt = value.toString.toInt
  }

  object Year {
    def apply(rawYear: Int): Either[String, Year] = {
      refineV[YearRule](rawYear).map(Year(_))
    }
  }
/*
  object DateTime extends TimeTypes {
    def apply(localDateTime: LocalDateTime): Either[String, DateTime] = {
      val splitDate = localDateTime.toString.split(Array('-', 'T', ':')).toInt
      for {
        year   <- refineV[Year](splitDate(0))
        month  <- refineV[Month](splitDate(1))
        day    <- refineV[Day](splitDate(2))
        hour   <- refineV[Hour](splitDate(3))
        second <- refineV[Second](splitDate(4))
        millis <- refineV[Millis](splitDate(5))
      } yield {
        DateTime(
          year   = year,
          month  = month,
          day    = day,
          hour   = hour,
          second = second,
          millis = millis
        )
      }
    }
  }
  */
}
