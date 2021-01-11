package domain.model.company

import org.scalatestplus.play._

class EmployeeTest extends PlaySpec {

  "If you pass the Employee model arguments correctly, they will be stored in Valid" in {
    Employee.create(
      rawFirstName = "test",
      rawLastName  = "テスト"
    ).isValid mustBe true
  }

  "If you pass the Employee model arguments with LicenseNumber correctly, they will be stored in Valid" in {
    Employee.create(
      rawFirstName = "test",
      rawLastName  = "テスト"
    ).isValid mustBe true
  }
}
