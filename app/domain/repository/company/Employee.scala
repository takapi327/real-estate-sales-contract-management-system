package domain.repository

import scala.concurrent.Future

import domain.model.company.Employee

trait EmployeeRepository {

  def add(employee: Employee): Future[Int]

  def findById(id: Employee.Id): Future[Option[Employee]]

}
