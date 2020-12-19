package gateway.repository 

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import library.backend.SlickRepository

import domain.model.company.Employee
import domain.repository.EmployeeRepository

import gateway.dao.EmployeeTable

class EmployeeRepositoryImpl @Inject()(
  implicit ec: ExecutionContext
) extends EmployeeRepository
  with    SlickRepository {

  import api._

  lazy val employeeTable = TableQuery[EmployeeTable]

  def add(employee: Employee): Future[Employee] = {
    db.run(
      (employeeTable returning employeeTable) += employee
    )
  }

  def findById(id: Employee.Id): Future[Option[Employee]] = {
    db.run(
      employeeTable.filter(_.id === id).result.headOption
    )
  }
}
