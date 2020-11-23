package domain.model.contract

import java.util.UUID

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.common._
import library.model.{Entity, EntityId}

case class Subscriber(
  id:           Subscriber.Id,
  firstName:    FirstName,
  lastName:     LastName,
  age:          Age,
  address:      Address,
  phoneNumber:  PhoneNumber,
  email:        Email
) extends Entity[Subscriber.Id]

object Subscriber extends EntityId {

  def create(
    rawFirstName:   String,
    rawLastName:    String,
    rawAge:         Int,
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
     age         <- Age(rawAge)
     address     <- Address(rawAddress)
     phoneNumber <- PhoneNumber(rawPhoneNumber)
     email       <- Email(rawEmail)
   } yield {
     Subscriber(
       id           = Id(UUID.randomUUID),
       firstName    = firstName,
       lastName     = lastName,
       age          = age,
       address      = address,
       phoneNumber  = phoneNumber,
       email        = email
     )
   }).toValidatedNel
  }
}
