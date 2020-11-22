package domain.model.property

import java.util.UUID

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.property._
import domain.value.common._

case class Property(
  propertyId:         Property.Id,
  address:            Address,
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
      address            <- Address(rawAddress)
      age                <- Age(rawAge)
      arrangementOfRooms <- ArrangementOfRooms(rawArrangementOfRooms)
    } yield {
      Property(
        propertyId         = Id(UUID.randomUUID),
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
