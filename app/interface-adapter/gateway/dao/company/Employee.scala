package gateway.dao

import slick.lifted.Tag

import library.backend.SlickTable
import library.backend.SlickDatabaseConfig

import domain.model.company._
import domain.model.company.Employee._
import domain.value.common.name._
import domain.value.common.address._
import domain.value.common.birthDate._
import domain.value.common.phone._
import domain.value.common.email._

class EmployeeTable(tag: Tag) extends SlickTable[Employee](tag, "employee") {

  import api._
  import mapping._

  /* @1  */ def id            = column[Employee.Id]          ("employee_id", O.PrimaryKey)
  /* @2  */ def firstName     = column[NameString]           ("first_name")
  /* @3  */ def lastName      = column[NameString]           ("last_name")
  /* @4  */ def birthYear     = column[YearInt]              ("birth_year")
  /* @5  */ def birthMonth    = column[MonthInt]             ("birth_month")
  /* @6  */ def birthDay      = column[DayInt]               ("birth_day")
  /* @7  */ def address       = column[AddressString]        ("address")
  /* @8  */ def phoneNumber   = column[PhoneNumberInt]       ("phone_number")
  /* @9  */ def email         = column[EmailString]          ("email")
  /* @10 */ def licenseNumber = column[LicenseNumberString]  ("license_number")

  type TableElementTuple = (
    Employee.Id,   NameString,     NameString,  YearInt, MonthInt, DayInt,
    AddressString, PhoneNumberInt, EmailString, Option[LicenseNumberString]
  )

  def * = (id, firstName, lastName, birthYear, birthMonth, birthDay, address, phoneNumber, email, licenseNumber.?) .<> (
    (x: TableElementTuple) => Employee(
      x._1,          FirstName(x._2),   LastName(x._3), Year(x._4), Month(x._5), Day(x._6),
      Address(x._7), PhoneNumber(x._8), Email(x._9),    x._10.map(LicenseNumber(_))
    ),
    (v: Employee) => Employee.unapply(v).map {t => (
      t._1,       t._2.value, t._3.value, t._4.value, t._5.value,
      t._6.value, t._7.value, t._8.value, t._9.value, t._10.map(_.value)
    )}
  )
}
