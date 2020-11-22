package domain.model.contract

import java.util.UUID

import domain.model.property.Property

import io.estatico.newtype.macros.newtype

case class ContractInformation (
  id:         ContractInformation.Id,
  propertyId: Property.Id,
  contents:   ContractInformation.Contents
)

object ContractInformation {
  case class Id (value: UUID)
  @newtype case class Contents(value: String)

  def create(
    rawPropertyId: Property.Id,
    rawContents:   String
  ): ContractInformation = {
    ContractInformation (
      id         = Id(UUID.randomUUID),
      propertyId = rawPropertyId,
      contents   = Contents(rawContents)
    ) 
  }
}
