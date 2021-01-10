package domain.model.company

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.common.address.Address
import domain.value.common.birthDate._
import domain.value.common.phone.PhoneNumber
import domain.value.common.email.Email

import eu.timepit.refined._
import eu.timepit.refined.string._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype

import EmployeeDetail.LicenseNumber
case class EmployeeDetail (
  employeeId:    Employee.Id,
  birthYear:     Year,
  birthMonth:    Month,
  birthDay:      Day,
  address:       Address,
  phoneNumber:   PhoneNumber,
  email:         Email,
  licenseNumber: Option[LicenseNumber]
)

object EmployeeDetail {

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
    rawEmployeeId:    Employee.Id,
    rawBirthYear:     Int,
    rawBirthMonth:    Int,
    rawBirthDay:      Int,
    rawAddress:       String,
    rawPhoneNumber:   String,
    rawEmail:         String,
    rawLicenseNumber: Option[String]
  ): ValidatedNel[String, EmployeeDetail] = {
    (for {
      birthYear     <- Year(rawBirthYear)
      birthMonth    <- Month(rawBirthMonth)
      birthDay      <- Day(rawBirthDay)
      address       <- Address(rawAddress)
      phoneNumber   <- PhoneNumber(rawPhoneNumber)
      email         <- Email(rawEmail)
      licenseNumber =  rawLicenseNumber.flatMap(f => LicenseNumber(f).toOption)
    } yield {
      EmployeeDetail (
        employeeId    = rawEmployeeId,
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