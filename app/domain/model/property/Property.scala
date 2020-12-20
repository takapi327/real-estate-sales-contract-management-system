package domain.model.property

import java.util.UUID

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.common.birthDate._
import domain.value.common.address.Address

import domain.value.property._
import domain.value.property.price.Price
import domain.value.property.arrangementofrooms.ArrangementOfRooms

import library.model.{Entity, EntityId}

case class Property(
  id:                 Property.Id,
  address:            Address,
  types:              Type,
  price:              Price,
  birthYear:          Year,
  birthMonth:         Month,
  birthDay:           Day,
  structure:          Structure,
  arrangementOfRooms: ArrangementOfRooms
) extends Entity[Property.Id]

object Property extends EntityId {

  def create(
    rawAddress:            String,
    rawTypeCode:           Int,
    rawPrice:              String,
    rawBirthYear:          Int,
    rawBirthMonth:         Int,
    rawBirthDay:           Int,
    rawStructureCode:      Int,
    rawArrangementOfRooms: String
  ): ValidatedNel[String, Property] = {
    (for {
      price              <- Price(rawPrice)
      address            <- Address(rawAddress)
      birthYear          <- Year(rawBirthYear)
      birthMonth         <- Month(rawBirthMonth)
      birthDay           <- Day(rawBirthDay)
      arrangementOfRooms <- ArrangementOfRooms(rawArrangementOfRooms)
    } yield {
      Property(
        id                 = Id(UUID.randomUUID),
        address            = address,
        types              = Type.find(rawTypeCode),
        price              = price,
        birthYear          = birthYear,
        birthMonth         = birthMonth,
        birthDay           = birthDay,
        structure          = Structure.find(rawStructureCode),
        arrangementOfRooms = arrangementOfRooms
      )
    }).toValidatedNel
  }
}
