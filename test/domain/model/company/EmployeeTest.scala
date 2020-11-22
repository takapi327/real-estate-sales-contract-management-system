package domain.model.company

import org.scalatest._
import org.scalatestplus.play._

class EmployeeTest extends FunSuite {

  test("If you pass the Employee model arguments correctly, they will be stored in Valid") {
    assert(
      Employee.create(
        rawFirstName     = "test",
        rawLastName      = "テスト",
        rawAge           = 25,
        rawAddress       = "hogehoge",
        rawPhoneNumber   = "090-1234-5678",
        rawEmail         = "test@ezweb.ne.jp",
        rawLicenseNumber = None
      ).isValid
    )
  }

  test("If you pass the Employee model arguments with LicenseNumber correctly, they will be stored in Valid") {
    assert(
      Employee.create(
        rawFirstName     = "test",
        rawLastName      = "テスト",
        rawAge           = 25,
        rawAddress       = "hogehoge",
        rawPhoneNumber   = "090-1234-5678",
        rawEmail         = "test@ezweb.ne.jp",
        rawLicenseNumber = Some(378792)
      ).isValid
    )
  }
}
