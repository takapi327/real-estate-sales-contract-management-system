package domain.model.company

import java.util.UUID

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.common.name._

import library.model.{Entity, EntityValue}

case class Employee (
  id:        Employee.Id,
  firstName: FirstName,
  lastName:  LastName,
) extends Entity[Employee.Id]

object Employee {

  case class Id(value: UUID) extends EntityValue[UUID]

  def create(
    rawFirstName: String,
    rawLastName:  String,
  ): ValidatedNel[String, Employee] = {
    (for {
       firstName <- FirstName(rawFirstName)
       lastName  <- LastName(rawLastName)
    } yield {
      Employee (
        id        = Id(UUID.randomUUID),
        firstName = firstName,
        lastName  = lastName
      )
    }).toValidatedNel
  }
}
