package gateway.dao

import slick.lifted.Tag

import library.backend.SlickTable
import domain.model.customer._

import domain.model.company.Employee
import domain.model.contract.{ContractOfBuy, ContractInformation}

class ContractOfBuyTable(tag: Tag) extends SlickTable[ContractOfBuy](tag, "contract_of_buy") {

  import api._
  import mapping._

  /* @1 */ def contractInformationId = column[ContractInformation.Id]  ("contract_information_id", O.PrimaryKey)
  /* @2 */ def subscriberId          = column[Subscriber.Id]           ("subscriber_id")
  /* @3 */ def employeeId            = column[Employee.Id]             ("employee_id")

  type TableElementTuple = (
    ContractInformation.Id, Subscriber.Id, Employee.Id,
  )

  def * = (contractInformationId, subscriberId, employeeId) .<> (
    (x: TableElementTuple) => ContractOfBuy(
      x._1, x._2, x._3
    ),
    (v: ContractOfBuy) => ContractOfBuy.unapply(v).map {t => (
      t._1, t._2, t._3
    )}
  )
}
