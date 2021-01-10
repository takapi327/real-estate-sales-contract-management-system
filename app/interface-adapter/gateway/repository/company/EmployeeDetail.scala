package gateway.repository

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import library.backend.SlickRepository

import domain.model.company.{Employee, EmployeeDetail}
import domain.repository.EmployeeDetailRepository

import gateway.dao.company.EmployeeDetailTable

class EmployeeDetailRepositoryImpl @Inject()(
  implicit ec: ExecutionContext
) extends EmployeeDetailRepository
  with    SlickRepository {

  import api._
  import mapping._

  lazy val employeeDetailTable = TableQuery[EmployeeDetailTable]

  def add(employeeDetail: EmployeeDetail): Future[Int] = {
    db.run (
      employeeDetailTable += employeeDetail
    )
  }

  def findByEmployeeId(employeeId: Employee.Id): Future[Option[EmployeeDetail]] = {
    db.run (
      employeeDetailTable.filter(_.employeeId === employeeId).result.headOption
    )
  }
}
