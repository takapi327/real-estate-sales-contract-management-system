package gateway.repository 

import java.util.UUID
import java.time.LocalDate

import cats.data.Validated.{Invalid, Valid}

import domain.model.property.Property

import library.backend.SlickRepositorySpec

class PropertyRepositorySpec extends SlickRepositorySpec {

  private val repository = fakeApplication.injector.instanceOf[PropertyRepositoryImpl]

  afterAll()

  "PropertyRepositoryImpl Test" should {

    "Can store records in DB" in {

      val property = Property.create(
        rawAddress            = "hogehoge",
        rawTypeCode           = 2,
        rawPrice              = "20,000,000",
        rawDateBuilt          = LocalDate.now(),
        rawStructureCode      = 4,
        rawArrangementOfRooms = "3LDK"
      )

      property match {
        case Valid(e)   => repository.add(e).futureValue mustBe 1
        case Invalid(e) => fail("Not Create Property")
      }

    }

    "Can retrieve records from DB by ID" in {
      val propertyId: Property.Id = Property.Id(UUID.fromString("2d407609-4ccd-408e-bd9e-d9f13b7757a8"))
      (repository.findById(propertyId).futureValue match {
        case Some(e) => true
        case None    => false
      }) mustBe true
    }
  }
}
