package gateway.dao

import slick.lifted.Tag

import library.backend.SlickTable
import library.backend.SlickDatabaseConfig

import domain.model.contract.Subscriber

import domain.value.common.age._
import domain.value.common.phone._
import domain.value.common.name._
import domain.value.common.email._
import domain.value.common.address._

class SubscriberTable(tag: Tag) extends SlickTable[Subscriber](tag, "subscriber") {

  import api._
  import mapping._

  /* @1 */ def id           = column[Subscriber.Id]     ("subscriber_id", O.PrimaryKey)
  /* @2 */ def firstName    = column[NameString]        ("first_name")
  /* @3 */ def lastName     = column[NameString]        ("last_name")
  /* @4 */ def age          = column[AgeInt]            ("age")
  /* @5 */ def address      = column[AddressString]     ("address")
  /* @6 */ def phoneNumber  = column[PhoneNumberInt]    ("phone_number")
  /* @7 */ def email        = column[EmailString]       ("email")

  type TableElementTuple = (
    Subscriber.Id, NameString,     NameString, AgeInt,
    AddressString, PhoneNumberInt, EmailString
  )

  def * = (id, firstName, lastName, age, address, phoneNumber, email) .<> (
    (x: TableElementTuple) => Subscriber(
      x._1, FirstName(x._2), LastName(x._3), Age(x._4), Address(x._5), PhoneNumber(x._6), Email(x._7)
    ),
    (v: Subscriber) => Subscriber.unapply(v).map {t => (
      t._1, t._2.value, t._3.value, t._4.value, t._5.value, t._6.value, t._7.value
    )}
  )
}
