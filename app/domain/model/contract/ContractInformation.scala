package domain.model.contract

import java.util.UUID

import domain.model.property.Property

import library.model.{Entity, EntityValue}

import io.estatico.newtype.macros.newtype

case class ContractInformation (
  id:         ContractInformation.Id,
  propertyId: Property.Id,
  contents:   ContractInformation.Contents
) extends Entity[ContractInformation.Id]

object ContractInformation {

  case class Id(value: UUID) extends EntityValue[UUID]

  @newtype case class Contents(value: String)

  def create(
    rawPropertyId: Property.Id,
    rawContents:   String
  ): ContractInformation = {
    ContractInformation(
      id         = Id(UUID.randomUUID),
      propertyId = rawPropertyId,
      contents   = Contents(rawContents)
    ) 
  }
}
