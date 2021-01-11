package domain.repository

import scala.concurrent.Future

import domain.model.company.{Employee, EmployeeDetail}

trait EmployeeDetailRepository {

  def add(employeeDetail: EmployeeDetail): Future[Int]

  def findByEmployeeId(employeeId: Employee.Id): Future[Option[EmployeeDetail]]

}
