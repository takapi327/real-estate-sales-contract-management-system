package domain.model.customer

import cats.data.ValidatedNel
import cats.implicits._
import domain.value.common.address.Address
import domain.value.common.birthDate._
import domain.value.common.email.Email
import domain.value.common.name._
import domain.value.common.phone.PhoneNumber
import library.model.{Entity, EntityValue}

import java.util.UUID

case class Subscriber(
  id:           Subscriber.Id,
  firstName:    FirstName,
  lastName:     LastName,
  birthYear:    Year,
  birthMonth:   Month,
  birthDay:     Day,
  address:      Address,
  phoneNumber:  PhoneNumber,
  email:        Email
) extends Entity[Subscriber.Id]

object Subscriber {

  case class Id(value: UUID) extends EntityValue[UUID]

  def create(
    rawFirstName:   String,
    rawLastName:    String,
    rawBirthYear:   Int,
    rawBirthMonth:  Int,
    rawBirthDay:    Int,
    rawAddress:     String,
    rawPhoneNumber: String,
    rawEmail:       String
  ): ValidatedNel[String, Subscriber] = {

  /**
   * @TODO: catsのmapNを使用して上手く処理したい
   */
   (for {
     firstName   <- FirstName(rawFirstName)
     lastName    <- LastName(rawLastName)
     birthYear   <- Year(rawBirthYear)
     birthMonth  <- Month(rawBirthMonth)
     birthDay    <- Day(rawBirthDay)
     address     <- Address(rawAddress)
     phoneNumber <- PhoneNumber(rawPhoneNumber)
     email       <- Email(rawEmail)
   } yield {
     Subscriber(
       id           = Id(UUID.randomUUID),
       firstName    = firstName,
       lastName     = lastName,
       birthYear    = birthYear,
       birthMonth   = birthMonth,
       birthDay     = birthDay,
       address      = address,
       phoneNumber  = phoneNumber,
       email        = email
     )
   }).toValidatedNel
  }
}
