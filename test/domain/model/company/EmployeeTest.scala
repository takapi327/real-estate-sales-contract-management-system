package domain.model.company

import org.scalatest._
import org.scalatestplus.play._

class EmployeeTest extends PlaySpec {

  "If you pass the Employee model arguments correctly, they will be stored in Valid" in {
    Employee.create(
      rawFirstName     = "test",
      rawLastName      = "テスト",
      rawBirthYear     = 1995,
      rawBirthMonth    = 7,
      rawBirthDay      = 15,
      rawAddress       = "hogehoge",
      rawPhoneNumber   = "09012345678",
      rawEmail         = "test@ezweb.ne.jp",
      rawLicenseNumber = None
    ).isValid mustBe true
  }

  "If you pass the Employee model arguments with LicenseNumber correctly, they will be stored in Valid" in {
    Employee.create(
      rawFirstName     = "test",
      rawLastName      = "テスト",
      rawBirthYear     = 1995,
      rawBirthMonth    = 7,
      rawBirthDay      = 15,
      rawAddress       = "hogehoge",
      rawPhoneNumber   = "09012345678",
      rawEmail         = "test@ezweb.ne.jp",
      rawLicenseNumber = Some("378792")
    ).isValid mustBe true
  }
}
