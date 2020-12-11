package gateway.dao

import slick.lifted.Tag

import library.backend.SlickTable
import library.backend.SlickDatabaseConfig

import domain.model.company.Employee
import domain.model.contract.{ContractOfSale, ContractInformation, Subscriber}

class ContractOfSaleTable(tag: Tag) extends SlickTable[ContractOfSale](tag, "contract_of_sale") {

  import api._
  import mapping._

  /* @1 */ def contractInformationId = column[ContractInformation.Id]  ("contract_information_id", O.PrimaryKey)
  /* @2 */ def subscriberId          = column[Subscriber.Id]           ("subscriber_id")
  /* @3 */ def employeeId            = column[Employee.Id]             ("employee_id")

  type TableElementTuple = (
    ContractInformation.Id, Subscriber.Id, Employee.Id,
  )

  def * = (contractInformationId, subscriberId, employeeId) .<> (
    (x: TableElementTuple) => ContractOfSale(
      x._1, x._2, x._3
    ),
    (v: ContractOfSale) => ContractOfSale.unapply(v).map {t => (
      t._1, t._2, t._3
    )}
  )
}
