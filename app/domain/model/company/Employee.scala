package domain.model.company

import java.util.UUID

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.common.name._
import domain.value.common.address.Address
import domain.value.common.birthDate._
import domain.value.common.phone.PhoneNumber
import domain.value.common.email.Email

import library.model.{Entity, EntityId}

import eu.timepit.refined._
import eu.timepit.refined.collection._
import eu.timepit.refined.string._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype

import Employee.LicenseNumber
case class Employee (
  id:            Employee.Id,
  firstName:     FirstName,
  lastName:      LastName,
  birthYear:     Year,
  birthMonth:    Month,
  birthDay:      Day,
  address:       Address,
  phoneNumber:   PhoneNumber,
  email:         Email,
  licenseNumber: Option[LicenseNumber]
) extends Entity[Employee.Id]

object Employee extends EntityId {

  type LicenseNumberRule   = MatchesRegex[W.`"[0-9]+"`.T]
  type LicenseNumberString = String Refined LicenseNumberRule

  @newtype case class LicenseNumber(value: LicenseNumberString) {
    def v = value.value
  }

  object LicenseNumber {
    def apply(rawLicenseNumber: String): Either[String, LicenseNumber] = {
      refineV[LicenseNumberRule](rawLicenseNumber).map(LicenseNumber(_))
    }
  }

  def create(
    rawFirstName:     String,
    rawLastName:      String,
    rawBirthYear:     Int,
    rawBirthMonth:    Int,
    rawBirthDay:      Int,
    rawAddress:       String,
    rawPhoneNumber:   String,
    rawEmail:         String,
    rawLicenseNumber: Option[String]
  ): ValidatedNel[String, Employee] = {
    (for {
       firstName     <- FirstName(rawFirstName)
       lastName      <- LastName(rawLastName)
       birthYear     <- Year(rawBirthYear)
       birthMonth    <- Month(rawBirthMonth)
       birthDay      <- Day(rawBirthDay)
       address       <- Address(rawAddress)
       phoneNumber   <- PhoneNumber(rawPhoneNumber)
       email         <- Email(rawEmail)
      licenseNumber  =  rawLicenseNumber.flatMap(f => LicenseNumber(f).toOption)
    } yield {
      Employee (
        id            = Id(UUID.randomUUID),
        firstName     = firstName,
        lastName      = lastName,
        birthYear     = birthYear,
        birthMonth    = birthMonth,
        birthDay      = birthDay,
        address       = address,
        phoneNumber   = phoneNumber,
        email         = email,
        licenseNumber = licenseNumber
      )
    }).toValidatedNel
  }
}
