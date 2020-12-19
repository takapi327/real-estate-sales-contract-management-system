package domain.value.common

import library.model.EntityValue
import java.time.LocalDate

case class BirthDate(value: LocalDate) extends EntityValue[LocalDate]

object BirthDate {
  def apply(rawBirthDate: LocalDate): BirthDate = {
    BirthDate(rawBirthDate)
  }
}
