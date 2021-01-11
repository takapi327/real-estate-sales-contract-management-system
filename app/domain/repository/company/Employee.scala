package domain.repository

import cats.data.NonEmptyList

import scala.concurrent.Future
import domain.model.company.Employee

trait EmployeeRepository {

  def add(employee: Employee): Future[Either[NonEmptyList[Any], Employee]]

  def findById(id: Employee.Id): Future[Either[NonEmptyList[Any], Employee]]

}
