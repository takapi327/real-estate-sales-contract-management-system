package gateway.repository 

import java.util.UUID

import cats.data.Validated.{Invalid, Valid}

import domain.model.customer.Subscriber
import library.backend.SlickRepositorySpec

class SubscriberRepositorySpec extends SlickRepositorySpec {

  private val repository = fakeApplication.injector.instanceOf[SubscriberRepositoryImpl]

  afterAll()

  "SubscriberRepositoryImpl Test" should {

    "Can store records in DB" in {

      val subscriber = Subscriber.create(
        rawFirstName = "test",
        rawLastName  = "テスト"
      )

      subscriber match {
        case Valid(v)   => repository.add(v).futureValue mustBe 1
        case Invalid(v) => fail("Not Create Subscriber")
      }

    }

    "Can retrieve records from DB by ID" in {
      val subscriberId: Subscriber.Id = Subscriber.Id(UUID.fromString("8aa1cff5-58e3-431c-92ed-9ddaa2fd63fb"))
      (repository.findById(subscriberId).futureValue match {
        case Some(e) => true
        case None    => false
      }) mustBe true
    }
  }
}
