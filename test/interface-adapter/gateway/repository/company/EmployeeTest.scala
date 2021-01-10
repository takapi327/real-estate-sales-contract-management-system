package gateway.repository 

import java.util.UUID

import cats.data.Validated.{Invalid, Valid}

import domain.model.company.Employee

import library.backend.SlickRepositorySpec

class EmployeeRepositorySpec extends SlickRepositorySpec {

  private val repository = fakeApplication.injector.instanceOf[EmployeeRepositoryImpl]

  afterAll()

  "EmployeeRepositoryImpl Test" should {

    "Can store records in DB" in {

      val employee = Employee.create(
        rawFirstName = "test",
        rawLastName  = "テスト"
      )

      employee match {
        case Valid(e)   => repository.add(e).futureValue mustBe 1
        case Invalid(e) => fail("Not Create Employee")
      }

    }

    "Can retrieve records from DB by ID" in {
      val employeeId: Employee.Id = Employee.Id(UUID.fromString("f069d88d-b622-4b5c-98e4-0538e04baf34"))
      (repository.findById(employeeId).futureValue match {
        case Some(e) => true
        case None    => false
      }) mustBe true
    }
  }
}
