package gateway.repository

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import cats.data.NonEmptyList

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

  def add(employeeDetail: EmployeeDetail): Future[Either[NonEmptyList[Any], EmployeeDetail]] = {
    db.run (
      employeeDetailTable += employeeDetail
    ).map(_ => Right(employeeDetail)).recover(error => Left(NonEmptyList.one(error)))
  }

  def findByEmployeeId(employeeId: Employee.Id): Future[Either[NonEmptyList[Any], EmployeeDetail]] = {
    db.run (
      employeeDetailTable.filter(_.employeeId === employeeId).result.headOption
    ).map(v => Right(v.get)).recover(error => Left(NonEmptyList.one(error)))
  }
}
