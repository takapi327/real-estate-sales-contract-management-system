package gateway.dao

import java.time.LocalDate
import slick.lifted.Tag

import library.backend.SlickTable
import library.backend.SlickDatabaseConfig

import domain.model.property.Property

import domain.value.common.address._

import domain.value.property._
import domain.value.property.price._
import domain.value.property.arrangementofrooms._

class PropertyTable(tag: Tag) extends SlickTable[Property](tag, "property") {

  import api._
  import mapping._

  /* @1 */ def id                 = column[Property.Id]                ("property_id", O.PrimaryKey)
  /* @2 */ def address            = column[AddressString]              ("address")
  /* @3 */ def types              = column[Int]                        ("types")
  /* @4 */ def price              = column[PriceString]                ("price")
  /* @5 */ def dateBuilt          = column[LocalDate]                  ("date_built")
  /* @6 */ def structure          = column[Int]                        ("structure")
  /* @7 */ def arrangementOfRooms = column[ArrangementOfRoomsString]   ("arrangement_of_rooms")

  type TableElementTuple = (
    Property.Id, AddressString, Int, PriceString, LocalDate,
    Int,         ArrangementOfRoomsString
  )

  def * = (id, address, types, price, dateBuilt, structure, arrangementOfRooms) .<> (
    (x: TableElementTuple) => Property(
      x._1, Address(x._2), Type.find(x._3), Price(x._4), x._5,
      Structure.find(x._6), ArrangementOfRooms(x._7)
    ),
    (v: Property) => Property.unapply(v).map {t => (
      t._1,      t._2.value, t._3.code, t._4.value, t._5,
      t._6.code, t._7.value
    )}
  )
}
