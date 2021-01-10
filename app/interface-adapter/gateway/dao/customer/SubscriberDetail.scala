package gateway.dao.customer

import slick.lifted.Tag
import library.backend.SlickTable

import domain.model.customer.{Subscriber, SubscriberDetail}
import domain.value.common.birthDate._
import domain.value.common.phone._
import domain.value.common.email._
import domain.value.common.address._

class SubscriberDetailTable(tag: Tag) extends SlickTable[SubscriberDetail](tag, "subscriber_detail") {

  import api._
  import mapping._

  /* @1 */ def id           = column[Subscriber.Id]     ("subscriber_id", O.PrimaryKey)
  /* @2 */ def birthYear    = column[YearInt]           ("birth_year")
  /* @3 */ def birthMonth   = column[MonthInt]          ("birth_month")
  /* @4 */ def birthDay     = column[DayInt]            ("birth_day")
  /* @5 */ def address      = column[AddressString]     ("address")
  /* @6 */ def phoneNumber  = column[PhoneNumberInt]    ("phone_number")
  /* @7 */ def email        = column[EmailString]       ("email")

  type TableElementTuple = (
    Subscriber.Id, YearInt, MonthInt,
      DayInt, AddressString,  PhoneNumberInt, EmailString
    )

  def * = (id, birthYear, birthMonth, birthDay, address, phoneNumber, email) .<> (
    (x: TableElementTuple) => SubscriberDetail(
      x._1, Year(x._2), Month(x._3),
      Day(x._4), Address(x._5), PhoneNumber(x._6), Email(x._7)
    ),
    (v: SubscriberDetail) => SubscriberDetail.unapply(v).map {t => (
      t._1, t._2.value, t._3.value, t._4.value, t._5.value,
      t._6.value, t._7.value
    )}
  )
}