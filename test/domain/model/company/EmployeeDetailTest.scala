package domain.model.company

import java.util.UUID

import org.scalatestplus.play._

class EmployeeDetailTest extends PlaySpec {

  "If you pass the EmployeeDetail model arguments correctly, they will be stored in Valid" in {
    EmployeeDetail.create(
      rawEmployeeId    = Employee.Id(UUID.fromString("1ab00caa-c323-48af-a831-3bfcdb52d16d")),
      rawBirthYear     = 1995,
      rawBirthMonth    = 7,
      rawBirthDay      = 15,
      rawAddress       = "hogehoge",
      rawPhoneNumber   = "09012345678",
      rawEmail         = "test@ezweb.ne.jp",
      rawLicenseNumber = None
    ).isValid mustBe true
  }

  "If you pass the EmployeeDetail model arguments with LicenseNumber correctly, they will be stored in Valid" in {
    EmployeeDetail.create(
      rawEmployeeId    = Employee.Id(UUID.fromString("1ab00caa-c323-48af-a831-3bfcdb52d16d")),
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