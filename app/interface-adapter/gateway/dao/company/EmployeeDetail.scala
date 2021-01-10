package gateway.dao

import slick.lifted.Tag

import library.backend.SlickTable

import domain.model.company._
import domain.model.company.EmployeeDetail._
import domain.value.common.address._
import domain.value.common.birthDate._
import domain.value.common.phone._
import domain.value.common.email._

class EmployeeDetailTable(tag: Tag) extends SlickTable[EmployeeDetail](tag, "employee_detail") {

  import api._
  import mapping._

  /* @1  */ def id            = column[Employee.Id]          ("employee_id",    O.PrimaryKey)
  /* @2  */ def birthYear     = column[YearInt]              ("birth_year")
  /* @3  */ def birthMonth    = column[MonthInt]             ("birth_month")
  /* @4  */ def birthDay      = column[DayInt]               ("birth_day")
  /* @5  */ def address       = column[AddressString]        ("address")
  /* @6  */ def phoneNumber   = column[PhoneNumberInt]       ("phone_number",   O.Unique)
  /* @7  */ def email         = column[EmailString]          ("email",          O.Unique)
  /* @8  */ def licenseNumber = column[LicenseNumberString]  ("license_number", O.Unique)

  type TableElementTuple = (
    Employee.Id,
    YearInt,
    MonthInt,
    DayInt,
    AddressString,
    PhoneNumberInt,
    EmailString,
    Option[LicenseNumberString]
  )

  def * = (id, birthYear, birthMonth, birthDay, address, phoneNumber, email, licenseNumber.?) .<> (
    (x: TableElementTuple) => EmployeeDetail(
      x._1, Year(x._2), Month(x._3), Day(x._4),
      Address(x._5), PhoneNumber(x._6), Email(x._7), x._8.map(LicenseNumber(_))
    ),
    (v: EmployeeDetail) => EmployeeDetail.unapply(v).map {t => (
      t._1,       t._2.value, t._3.value, t._4.value, t._5.value,
      t._6.value, t._7.value, t._8.map(_.value)
    )}
  )
}
