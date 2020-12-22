package domain.model.property

import java.time.LocalDate

import org.scalatest._
import org.scalatestplus.play._

class PropertyTest extends PlaySpec {
  "If you pass the Property model arguments correctly, they will be stored in Valid" in {
    Property.create(
      rawAddress            = "hogehoge",
      rawTypeCode           = 2,
      rawPrice              = "20,000,000",
      rawDateBuilt          = LocalDate.now(),
      rawStructureCode      = 4,
      rawArrangementOfRooms = "3LDK"
    ).isValid mustBe true
  }
}
