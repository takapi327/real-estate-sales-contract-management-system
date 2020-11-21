package domain.model.company

import java.util.UUID

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.common._
import domain.value.common.email._
import domain.value.common.name._
import domain.value.common.phone._

import io.estatico.newtype.macros.newtype

import Employee._
case class Employee (
  employeeId:    Employee.Id,
  firstName:     FirstName,
  lastName:      LastName,
  age:           Age,
  address:       String,
  phoneNumber:   PhoneNumber,
  email:         Email,
  licenseNumber: Option[LicenseNumber]
)

object Employee {

  case class Id(value: UUID)
  @newtype case class LicenseNumber(value: Int)

  def create(
    rawFirstName:     String,
    rawLastName:      String,
    rawAge:           Int,
    rawAddress:       String,
    rawPhoneNumber:   String,
    rawEmail:         String,
    rawLicenseNumber: Option[Int]
  ): ValidatedNel[String, Employee] = {
    (for {
       firstName   <- FirstName(rawFirstName)
       lastName    <- LastName(rawLastName)
       age         <- Age(rawAge)
       phoneNumber <- PhoneNumber(rawPhoneNumber)
       email       <- Email(rawEmail)
    } yield {
      Employee (
        employeeId    = Id(UUID.randomUUID),
        firstName     = firstName,
        lastName      = lastName,
        age           = age,
        address       = rawAddress,
        phoneNumber   = phoneNumber,
        email         = email,
        licenseNumber = rawLicenseNumber.map(LicenseNumber(_))
      )
    }).toValidatedNel
  }
}
