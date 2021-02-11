package gateway.repository

import cats.data.EitherT
import cats.implicits._

import domain.model.customer.Subscriber
import library.backend.SlickRepositorySpec

import scala.concurrent.Future

class SubscriberRepositorySpec extends SlickRepositorySpec {

  private val repository = fakeApplication.injector.instanceOf[SubscriberRepositoryImpl]

  val subscriberValidate = Subscriber.create(
    rawFirstName = "test",
    rawLastName  = "テスト"
  )

  val subscriber = for {
    subscriberEntity <- EitherT.fromEither[Future](subscriberValidate.toEither)
    subscriber       <- EitherT(repository.add(subscriberEntity))
  } yield {
    subscriber
  }

  "SubscriberRepositoryImpl Test" should {

    "Can store records in DB" in {
      subscriber.value.futureValue mustBe subscriberValidate.toEither
    }

    "Can retrieve records from DB by ID" in {
      val result = for {
        subscriberEntity <- subscriber
        subscriber       <- EitherT(repository.findById(subscriberEntity.id))
      } yield {
        subscriber
      }

      result.value.futureValue mustBe subscriberValidate.toEither
    }
  }

  afterAll()
}
