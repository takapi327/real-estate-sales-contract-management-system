package gateway.dao

import slick.lifted.Tag

import library.backend.SlickTable
import library.backend.SlickDatabaseConfig

import domain.model.company._
import domain.model.company.Employee._
import domain.value.common.name._
import domain.value.common.address._
import domain.value.common.age._
import domain.value.common.phone._
import domain.value.common.email._

class EmployeeTable(tag: Tag) extends SlickTable[Employee](tag, "employee") {

  import api._
  import mapping._

  /* @1 */ def id            = column[Employee.Id]          ("employee_id", O.PrimaryKey)
  /* @2 */ def firstName     = column[NameString]           ("first_name")
  /* @3 */ def lastName      = column[NameString]           ("last_name")
  /* @4 */ def age           = column[AgeInt]               ("age")
  /* @5 */ def address       = column[AddressString]        ("address")
  /* @6 */ def phoneNumber   = column[PhoneNumberInt]       ("phone_number")
  /* @7 */ def email         = column[EmailString]          ("email")
  /* @8 */ def licenseNumber = column[LicenseNumberString]  ("license_number")

  type TableElementTuple = (
    Employee.Id,   NameString,     NameString,  AgeInt,
    AddressString, PhoneNumberInt, EmailString, Option[LicenseNumberString]
  )

  def * = (id, firstName, lastName, age, address, phoneNumber, email, licenseNumber.?) .<> (
    (x: TableElementTuple) => Employee(
      x._1,          FirstName(x._2),   LastName(x._3), Age(x._4),
      Address(x._5), PhoneNumber(x._6), Email(x._7),    x._8.map(LicenseNumber(_))
    ),
    (v: Employee) => Employee.unapply(v).map {t => (
      t._1, t._2.value, t._3.value, t._4.value, t._5.value, t._6.value, t._7.value, t._8.map(_.value)
    )}
  )
}
