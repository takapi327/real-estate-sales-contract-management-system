package domain.model.contract

import java.util.UUID

import domain.model.contract.ContractInformation

import io.estatico.newtype.macros.newtype

case class PaymentSlip (
  id:            PaymentSlip.Id,
  informationId: ContractInformation.Id,
  itemName:      PaymentSlip.ItemName,
  money:         PaymentSlip.Money
)

object PaymentSlip {
  case class Id (value: UUID)
  @newtype case class ItemName(value: String)
  @newtype case class Money(value: Int)

  def create(
    rawInfomationId: ContractInformation.Id,
    rawItemName:     String,
    rawMoney:        Int
  ): PaymentSlip = {
    PaymentSlip (
      id            = Id(UUID.randomUUID),
      informationId = rawInfomationId,
      itemName      = ItemName(rawItemName),
      money         = Money(rawMoney)
    ) 
  }
}
