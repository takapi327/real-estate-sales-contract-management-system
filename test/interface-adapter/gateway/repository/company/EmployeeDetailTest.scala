package gateway.repository

import scala.concurrent.Future
import cats.data.EitherT
import cats.implicits._
import domain.model.company.{Employee, EmployeeDetail}
import library.backend.SlickRepositorySpec

class EmployeeDetailRepositorySpec extends SlickRepositorySpec {

  private val employeeRepository       = fakeApplication.injector.instanceOf[EmployeeRepositoryImpl]
  private val employeeDetailRepository = fakeApplication.injector.instanceOf[EmployeeDetailRepositoryImpl]

  val employeeValidate = Employee.create(
    rawFirstName = "test",
    rawLastName  = "テスト"
  )

  val employeeDetail = for {
    employeeModel <- EitherT.fromEither[Future](employeeValidate.toEither)
    employee      <- EitherT(employeeRepository.add(employeeModel))
    employeeDetailValidate = EmployeeDetail.create(
      rawEmployeeId    = employee.id,
      rawBirthYear     = 1995,
      rawBirthMonth    = 7,
      rawBirthDay      = 15,
      rawAddress       = "hogehoge",
      rawPhoneNumber   = "09012345678",
      rawEmail         = "test@ezweb.ne.jp",
      rawLicenseNumber = None
    )
    employeeDetailModel <- EitherT.fromEither[Future](employeeDetailValidate.toEither)
    employeeDetail      <- EitherT(employeeDetailRepository.add(employeeDetailModel))
  } yield {
    employeeDetail
  }

  "EmployeeRepositoryImpl Test" should {

    "Can store records in DB" in {
      employeeDetail.value.futureValue.isRight
    }

    "Can retrieve records from DB by ID" in {
      val result = for {
        employeeDetailEntity <- employeeDetail
        employeeDetail       <- EitherT(employeeDetailRepository.findByEmployeeId(employeeDetailEntity.employeeId))
      } yield {
        employeeDetail
      }
      result.value.futureValue.isRight
    }
  }

}