package gateway.dao.customer

import slick.lifted.Tag
import library.backend.SlickTable

import domain.model.customer.Subscriber
import domain.value.common.name._

class SubscriberTable(tag: Tag) extends SlickTable[Subscriber](tag, "subscriber") {

  import api._
  import mapping._

  /* @1 */ def id        = column[Subscriber.Id] ("id", O.PrimaryKey)
  /* @2 */ def firstName = column[NameString]    ("first_name")
  /* @3 */ def lastName  = column[NameString]    ("last_name")

  type TableElementTuple = (
    Subscriber.Id, NameString, NameString,
    )

  def * = (id, firstName, lastName) .<> (
    (x: TableElementTuple) => Subscriber(
      x._1, FirstName(x._2), LastName(x._3)
    ),
    (v: Subscriber) => Subscriber.unapply(v).map {t => (
      t._1, t._2.value, t._3.value
    )}
  )
}