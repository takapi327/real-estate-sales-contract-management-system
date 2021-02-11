package domain.repository

import cats.data.NonEmptyList

import scala.concurrent.Future

import domain.model.company.{Employee, EmployeeDetail}

trait EmployeeDetailRepository {

  def add(employeeDetail: EmployeeDetail): Future[Either[NonEmptyList[Any], EmployeeDetail]]

  def findByEmployeeId(employeeId: Employee.Id): Future[Either[NonEmptyList[Any], EmployeeDetail]]

}
