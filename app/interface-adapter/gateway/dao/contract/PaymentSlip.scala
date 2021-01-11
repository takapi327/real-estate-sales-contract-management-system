package gateway.dao.contract

import slick.lifted.Tag

import library.backend.SlickTable

import domain.model.contract.PaymentSlip
import domain.model.contract.ContractInformation
import domain.value.property.price._

import PaymentSlip._
class PaymentSlipTable(tag: Tag) extends SlickTable[PaymentSlip](tag, "payment_slip") {

  import api._
  import mapping._

  /* @1 */ def id             = column[PaymentSlip.Id]          ("id", O.PrimaryKey)
  /* @2 */ def informationId  = column[ContractInformation.Id]  ("contract_information_id")
  /* @3 */ def itemName       = column[String]                  ("item_name")
  /* @4 */ def price          = column[PriceString]             ("price")

  type TableElementTuple = (
    PaymentSlip.Id, ContractInformation.Id, String, PriceString
  )

  def * = (id, informationId, itemName, price) .<> (
    (x: TableElementTuple) => PaymentSlip(
      x._1, x._2, ItemName(x._3), Price(x._4)
    ),
    (v: PaymentSlip) => PaymentSlip.unapply(v).map {t => (
      t._1, t._2, t._3.value, t._4.value
    )}
  )
}
