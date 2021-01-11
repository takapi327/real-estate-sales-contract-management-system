package gateway.repository 

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import cats.data.NonEmptyList

import library.backend.SlickRepository

import domain.model.company.Employee
import domain.repository.EmployeeRepository

import gateway.dao.company.EmployeeTable

class EmployeeRepositoryImpl @Inject()(
  implicit ec: ExecutionContext
) extends EmployeeRepository
  with    SlickRepository {

  import api._
  import mapping._

  lazy val employeeTable = TableQuery[EmployeeTable]

  def add(employee: Employee): Future[Either[NonEmptyList[Any], Employee]] = {
    db.run (
      employeeTable += employee
    ).map(_ => Right(employee)).recover(error => Left(NonEmptyList.one(error)))
  }

  def findById(id: Employee.Id): Future[Either[NonEmptyList[Any], Employee]] = {
    db.run (
      employeeTable.filter(_.id === id).result.headOption
    ).map(v => Right(v.get)).recover(error => Left(NonEmptyList.one(error)))
  }
}
