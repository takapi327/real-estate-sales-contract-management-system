package domain.model.contract

import java.util.UUID

import domain.model.contract.ContractInformation

import library.model.{Entity, EntityId}

import io.estatico.newtype.macros.newtype

case class Agreement (
  id:           Agreement.Id,
  infomationId: ContractInformation.Id,
  name:         Agreement.Name
) extends Entity[Agreement.Id]

object Agreement extends EntityId {

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
