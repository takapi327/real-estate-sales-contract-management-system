package domain.model.company

import java.util.UUID

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.common._

import library.model.EntityId

import io.estatico.newtype.macros.newtype

import Employee.LicenseNumber
case class Employee (
  id:            Employee.Id,
  firstName:     FirstName,
  lastName:      LastName,
  age:           Age,
  address:       Address,
  phoneNumber:   PhoneNumber,
  email:         Email,
  licenseNumber: Option[LicenseNumber]
)

object Employee extends EntityId {

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
       address     <- Address(rawAddress)
       phoneNumber <- PhoneNumber(rawPhoneNumber)
       email       <- Email(rawEmail)
    } yield {
      Employee (
        id            = Id(UUID.randomUUID),
        firstName     = firstName,
        lastName      = lastName,
        age           = age,
        address       = address,
        phoneNumber   = phoneNumber,
        email         = email,
        licenseNumber = rawLicenseNumber.map(LicenseNumber(_))
      )
    }).toValidatedNel
  }
}
