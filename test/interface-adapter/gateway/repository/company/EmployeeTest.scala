package gateway.repository

import scala.concurrent.Future

import cats.data.EitherT
import cats.implicits._

import domain.model.company.Employee

import library.backend.SlickRepositorySpec

class EmployeeRepositorySpec extends SlickRepositorySpec {

  private val repository = fakeApplication.injector.instanceOf[EmployeeRepositoryImpl]

  val employeeValidate = Employee.create(
    rawFirstName = "test",
    rawLastName  = "テスト"
  )

  val employeeData = for {
    employeeModel <- EitherT.fromEither[Future](employeeValidate.toEither)
    employee      <- EitherT(repository.add(employeeModel))
  } yield {
    employee
  }

  "EmployeeRepositoryImpl Test" should {

    "Can store records in DB" in {

      employeeData.value.futureValue mustBe employeeValidate.toEither

    }

    "Can retrieve records from DB by ID" in {

      val result = for {
        employeeData  <- employeeData
        employee      <- EitherT(repository.findById(employeeData.id))
      } yield {
        employee
      }

      result.value.futureValue mustBe employeeValidate.toEither

    }

    afterAll()

  }
}
