package gateway.dao.contract

import slick.lifted.Tag

import library.backend.SlickTable

import domain.model.property.Property
import domain.model.contract._

import ContractInformation._
class ContractInformationTable(tag: Tag) extends SlickTable[ContractInformation](tag, "contract_information") {

  import api._
  import mapping._

  /* @1 */ def id         = column[ContractInformation.Id]  ("contract_information_id", O.PrimaryKey)
  /* @2 */ def propertyId = column[Property.Id]             ("property_id")
  /* @3 */ def contents   = column[String]                  ("contents")

  type TableElementTuple = (
    ContractInformation.Id, Property.Id, String
  )

  def * = (id, propertyId, contents) .<> (
    (x: TableElementTuple) => ContractInformation(
      x._1, x._2, Contents(x._3)
    ),
    (v: ContractInformation) => ContractInformation.unapply(v).map {t => (
      t._1, t._2, t._3.value
    )}
  )
}
