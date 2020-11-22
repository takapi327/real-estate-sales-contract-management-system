package domain.model.contract

import java.util.UUID

import domain.model.contract.ContractInformation

import io.estatico.newtype.macros.newtype

case class Agreement (
  id:           Agreement.Id,
  infomationId: ContractInformation.Id,
  name:         Agreement.Name
)

object Agreement {
  case class Id (value: UUID)
  @newtype case class Name(value: String)

  def create(
    rawInfomationId: ContractInformation.Id,
    rawName:         String
  ): Agreement = {
    Agreement (
      id           = Id(UUID.randomUUID),
      infomationId = rawInfomationId,
      name         = Name(rawName)
    ) 
  }
}
