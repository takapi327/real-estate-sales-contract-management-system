package domain.repository

import scala.concurrent.Future

import domain.model.company.Employee

trait EmployeeRepository {

  def add(employee: Employee): Future[Employee]

  def findByEmployeeId(employeeId: Employee.Id): Future[Option[Employee]]

}
