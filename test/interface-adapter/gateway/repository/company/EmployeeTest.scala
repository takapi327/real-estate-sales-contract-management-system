package gateway.repository 

import java.util.UUID

import org.scalatest._
import org.scalatestplus.play._

import cats.data.Validated.{Invalid, Valid}
import cats.implicits._

import domain.model.company.Employee

import library.backend.SlickRepositorySpec
import gateway.dao.EmployeeTable

class EmployeeRepositorySpec extends SlickRepositorySpec {

  private val repository = fakeApplication.injector.instanceOf[EmployeeRepositoryImpl]

  afterAll()

  "EmployeeRepositoryImpl Test" should {

    "Can store records in DB" in {

      val employee = Employee.create(
        rawFirstName     = "test",
        rawLastName      = "テスト",
        rawBirthYear     = 1995,
        rawBirthMonth    = 7,
        rawBirthDay      = 15,
        rawAddress       = "hogehoge",
        rawPhoneNumber   = "09012345678",
        rawEmail         = "test@ezweb.ne.jp",
        rawLicenseNumber = None
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
