package domain.model.customer

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.common.address.Address
import domain.value.common.birthDate._
import domain.value.common.email.Email
import domain.value.common.phone.PhoneNumber

case class SubscriberDetail(
  subscriberId: Subscriber.Id,
  birthYear:    Year,
  birthMonth:   Month,
  birthDay:     Day,
  address:      Address,
  phoneNumber:  PhoneNumber,
  email:        Email
)

object SubscriberDetail {

  def create(
  rawSubscriberId: Subscriber.Id,
  rawBirthYear:    Int,
  rawBirthMonth:   Int,
  rawBirthDay:     Int,
  rawAddress:      String,
  rawPhoneNumber:  String,
  rawEmail:        String
): ValidatedNel[String, SubscriberDetail] = {

    /**
     * @TODO: catsのmapNを使用して上手く処理したい
     */
    (for {
      birthYear   <- Year(rawBirthYear)
      birthMonth  <- Month(rawBirthMonth)
      birthDay    <- Day(rawBirthDay)
      address     <- Address(rawAddress)
      phoneNumber <- PhoneNumber(rawPhoneNumber)
      email       <- Email(rawEmail)
    } yield {
      SubscriberDetail(
        subscriberId = rawSubscriberId,
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