package domain.model.contract

import java.util.UUID

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.common.age._
import domain.value.common.name._

import io.estatico.newtype.macros.newtype

import ResidentialProperties._
case class ResidentialProperties(
  residentialPropertiesId: ResidentialProperties.Id,
  firstName:               FirstName,
  lastName:                LastName,
  age:                     Age,
  licenseNumber:           LicenseNumber,
 // companyId:               Company.Id
)

object ResidentialProperties {

  case class Id(value: UUID)
  @newtype case class LicenseNumber(value: Int)

  def create(
    rawFirstName:     String,
    rawLastName:      String,
    rawAge:           Int,
    rawLicenseNumber: Int,
    //rawCompanyId:     Long
  ): ValidatedNel[String, ResidentialProperties] = {
    (for {
       firstName <- FirstName(rawFirstName)
       lastName  <- LastName(rawLastName)
       age       <- Age(rawAge)
    } yield {
       ResidentialProperties(
         residentialPropertiesId = Id(UUID.randomUUID),
         firstName               = firstName,
         lastName                = lastName,
         age                     = age,
         licenseNumber           = LicenseNumber(rawLicenseNumber)
      )
    }).toValidatedNel
  }
}
