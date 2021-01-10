package domain.model.customer

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.common.name._

import library.model.{Entity, EntityValue}

import java.util.UUID

case class Subscriber(
  id:        Subscriber.Id,
  firstName: FirstName,
  lastName:  LastName,
) extends Entity[Subscriber.Id]

object Subscriber {

  case class Id(value: UUID) extends EntityValue[UUID]

  def create(
    rawFirstName: String,
    rawLastName:  String,
  ): ValidatedNel[String, Subscriber] = {

  /**
   * @TODO: catsのmapNを使用して上手く処理したい
   */
   (for {
     firstName <- FirstName(rawFirstName)
     lastName  <- LastName(rawLastName)
   } yield {
     Subscriber(
       id        = Id(UUID.randomUUID),
       firstName = firstName,
       lastName  = lastName
     )
   }).toValidatedNel
  }
}
