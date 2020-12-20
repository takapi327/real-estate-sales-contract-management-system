package gateway.dao

import slick.lifted.Tag

import library.backend.SlickTable
import library.backend.SlickDatabaseConfig

import domain.model.property.Property

import domain.value.common.birthDate._
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
  /* @5 */ def birthYear          = column[YearInt]                    ("birth_year")
  /* @6 */ def birthMonth         = column[MonthInt]                   ("birth_month")
  /* @7 */ def birthDay           = column[DayInt]                     ("birth_day")
  /* @8 */ def structure          = column[Int]                        ("structure")
  /* @9 */ def arrangementOfRooms = column[ArrangementOfRoomsString]   ("arrangement_of_rooms")

  type TableElementTuple = (
    Property.Id, AddressString, Int,    PriceString,
    YearInt,     MonthInt,      DayInt, Int, ArrangementOfRoomsString
  )

  def * = (id, address, types, price, birthYear, birthMonth, birthDay, structure, arrangementOfRooms) .<> (
    (x: TableElementTuple) => Property(
      x._1,        Address(x._2), Type.find(x._3),      Price(x._4), Year(x._5),
      Month(x._6), Day(x._7),     Structure.find(x._8), ArrangementOfRooms(x._9)
    ),
    (v: Property) => Property.unapply(v).map {t => (
      t._1,       t._2.value, t._3.code, t._4.value, t._5.value,
      t._6.value, t._7.value, t._8.code, t._9.value
    )}
  )
}
