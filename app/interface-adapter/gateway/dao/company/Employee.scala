package gateway.dao.company

import slick.lifted.Tag

import library.backend.SlickTable

import domain.model.company._
import domain.value.common.name._

class EmployeeTable(tag: Tag) extends SlickTable[Employee](tag, "employee") {

  import api._
  import mapping._

  /* @1  */ def id        = column[Employee.Id] ("id", O.PrimaryKey)
  /* @2  */ def firstName = column[NameString]  ("first_name")
  /* @3  */ def lastName  = column[NameString]  ("last_name")

  type TableElementTuple = (
    Employee.Id, NameString, NameString
  )

  def * = (id, firstName, lastName) .<> (
    (x: TableElementTuple) => Employee(
      x._1, FirstName(x._2), LastName(x._3)
    ),
    (v: Employee) => Employee.unapply(v).map {t => (
      t._1, t._2.value, t._3.value
    )}
  )
}
