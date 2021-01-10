package domain.model.contract

import java.util.UUID

import cats.data.ValidatedNel
import cats.implicits._

import domain.value.property.price.Price

import library.model.{Entity, EntityValue}

import io.estatico.newtype.macros.newtype

case class PaymentSlip (
  id:            PaymentSlip.Id,
  informationId: ContractInformation.Id,
  itemName:      PaymentSlip.ItemName,
  price:         Price
) extends Entity[PaymentSlip.Id]

object PaymentSlip {

  case class Id(value: UUID) extends EntityValue[UUID]

  @newtype case class ItemName(value: String)

  def create(
    rawInfomationId: ContractInformation.Id,
    rawItemName:     String,
    rawPrice:        String
  ): ValidatedNel[String, PaymentSlip] = {
    (for {
      price <- Price(rawPrice)
    } yield {
      PaymentSlip (
        id            = Id(UUID.randomUUID),
        informationId = rawInfomationId,
        itemName      = ItemName(rawItemName),
        price         = price
      )
   }).toValidatedNel
  }
}
