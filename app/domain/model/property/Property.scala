package domain.model.property

import java.util.UUID

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.property.types._
import domain.value.property.price._
import domain.value.property.structure._
import domain.value.property.arrangementofrooms._

import domain.value.common.age._

case class Property(
  propertyId:         Property.Id,
  address:            String,
  types:              Type,
  price:              Price,
  age:                Age,
  structure:          Structure,
  arrangementOfRooms: ArrangementOfRooms
)

object Property {

  case class Id(value: UUID)

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
      age                <- Age(rawAge)
      arrangementOfRooms <- ArrangementOfRooms(rawArrangementOfRooms)
    } yield {
      Property(
        propertyId         = Id(UUID.randomUUID),
        address            = rawAddress,
        types              = Type.find(rawTypeCode),
        price              = price,
        age                = age,
        structure          = Structure.find(rawStructureCode),
        arrangementOfRooms = arrangementOfRooms
      )
    }).toValidatedNel
  }
}
