package domain.model.property

import java.util.UUID
import java.time.LocalDate

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.common.address.Address

import domain.value.property._
import domain.value.property.price.Price
import domain.value.property.arrangementofrooms.ArrangementOfRooms

import library.model.{Entity, EntityValue}

case class Property(
  id:                 Property.Id,
  address:            Address,
  types:              Type,
  price:              Price,
  dateBuilt:          LocalDate,
  structure:          Structure,
  arrangementOfRooms: ArrangementOfRooms
) extends Entity[Property.Id]

object Property {

  case class Id(value: UUID) extends EntityValue[UUID]

  def create(
    rawAddress:            String,
    rawTypeCode:           Int,
    rawPrice:              String,
    rawDateBuilt:          LocalDate,
    rawStructureCode:      Int,
    rawArrangementOfRooms: String
  ): ValidatedNel[String, Property] = {
    (for {
      price              <- Price(rawPrice)
      address            <- Address(rawAddress)
      arrangementOfRooms <- ArrangementOfRooms(rawArrangementOfRooms)
    } yield {
      Property(
        id                 = Id(UUID.randomUUID),
        address            = address,
        types              = Type.find(rawTypeCode),
        price              = price,
        dateBuilt          = rawDateBuilt,
        structure          = Structure.find(rawStructureCode),
        arrangementOfRooms = arrangementOfRooms
      )
    }).toValidatedNel
  }
}
