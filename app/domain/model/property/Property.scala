package domain.model.property

import java.util.UUID

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.property._
import domain.value.common._

import library.model.{Entity, EntityId}

case class Property(
  id:                 Property.Id,
  address:            Address,
  types:              Type,
  price:              Price,
  age:                Age,
  structure:          Structure,
  arrangementOfRooms: ArrangementOfRooms
) extends Entity[Property.Id]

object Property extends EntityId {

  def create(
    rawAddress:            String,
    rawTypeCode:           Int,
    rawPrice:              String,
    rawAge:                Int,
    rawStructureCode:      Int,
    rawArrangementOfRooms: String
  ): ValidatedNel[String, Property] = {
    (for {
      price              <- Price(rawPrice)
      address            <- Address(rawAddress)
      age                <- Age(rawAge)
      arrangementOfRooms <- ArrangementOfRooms(rawArrangementOfRooms)
    } yield {
      Property(
        id                 = Id(UUID.randomUUID),
        address            = address,
        types              = Type.find(rawTypeCode),
        price              = price,
        age                = age,
        structure          = Structure.find(rawStructureCode),
        arrangementOfRooms = arrangementOfRooms
      )
    }).toValidatedNel
  }
}
