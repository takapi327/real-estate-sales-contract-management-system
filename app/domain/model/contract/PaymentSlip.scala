package domain.model.contract

import java.util.UUID

import cats.data.ValidatedNel
import cats.implicits._

import domain.model.contract.ContractInformation
import domain.value.property._

import library.model.EntityId

import io.estatico.newtype.macros.newtype

case class PaymentSlip (
  id:            PaymentSlip.Id,
  informationId: ContractInformation.Id,
  itemName:      PaymentSlip.ItemName,
  price:         Price
)

object PaymentSlip extends EntityId {

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
