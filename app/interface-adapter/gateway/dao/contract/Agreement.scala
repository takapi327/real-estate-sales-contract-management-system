package gateway.dao

import slick.lifted.Tag

import library.backend.SlickTable
import library.backend.SlickDatabaseConfig

import domain.model.contract.{Agreement, ContractInformation}

import Agreement.Name
class AgreementTable(tag: Tag) extends SlickTable[Agreement](tag, "agreement") {

  import api._
  import mapping._

  /* @1 */ def id                    = column[Agreement.Id]            ("agreement_id", O.PrimaryKey)
  /* @2 */ def contractInformationId = column[ContractInformation.Id]  ("contract_information_id")
  /* @3 */ def name                  = column[String]                  ("name")

  type TableElementTuple = (
    Agreement.Id, ContractInformation.Id, String,
  )

  def * = (id, contractInformationId, name) .<> (
    (x: TableElementTuple) => Agreement(
      x._1, x._2, Name(x._3)
    ),
    (v: Agreement) => Agreement.unapply(v).map {t => (
      t._1, t._2, t._3.value
    )}
  )
}
