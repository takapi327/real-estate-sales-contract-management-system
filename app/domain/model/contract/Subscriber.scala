package domain.model.contract

import java.util.UUID

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.common._
import domain.value.common.phone._

case class Subscriber(
  subscriberId: Subscriber.Id,
  firstName:    FirstName,
  lastName:     LastName,
  age:          Age,
  address:      String,
  phoneNumber:  PhoneNumber,
  email:        Email
)

object Subscriber {

  case class Id(value: UUID)

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
     phoneNumber <- PhoneNumber(rawPhoneNumber)
     email       <- Email(rawEmail)
   } yield {
     Subscriber(
       subscriberId = Id(UUID.randomUUID),
       firstName    = firstName,
       lastName     = lastName,
       age          = age,
       address      = rawAddress,
       phoneNumber  = phoneNumber,
       email        = email
     )
   }).toValidatedNel
  }
}
