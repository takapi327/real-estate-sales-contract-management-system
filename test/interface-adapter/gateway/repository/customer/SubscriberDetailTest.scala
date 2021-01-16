package gateway.repository

import scala.concurrent.Future
import cats.data.EitherT
import cats.implicits._
import domain.model.customer.{Subscriber, SubscriberDetail}
import library.backend.SlickRepositorySpec

class SubscriberDetailRepositorySpec extends SlickRepositorySpec {

  private val subscriberRepository       = fakeApplication.injector.instanceOf[SubscriberRepositoryImpl]
  private val subscriberDetailRepository = fakeApplication.injector.instanceOf[SubscriberDetailRepositoryImpl]

  val subscriber = Subscriber.create(
    rawFirstName = "test",
    rawLastName  = "テスト"
  )

  val subscriberDetail = for {
    subscriberEntity <- EitherT.fromEither[Future](subscriber.toEither)
    subscriber      <- EitherT(subscriberRepository.add(subscriberEntity))
    subscriberDetailValid = SubscriberDetail.create(
      rawSubscriberId = subscriber.id,
      rawBirthYear    = 1995,
      rawBirthMonth   = 7,
      rawBirthDay     = 15,
      rawAddress      = "hogehoge",
      rawPhoneNumber  = "0901234567",
      rawEmail        = "test@ezweb.ne.jp"
    )
    subscriberDetailEntity <- EitherT.fromEither[Future](subscriberDetailValid.toEither)
    subscriberDetail      <- EitherT(subscriberDetailRepository.add(subscriberDetailEntity))
  } yield {
    subscriberDetail
  }

  "SubscriberDetailRepositoryImpl Test" should {

    "Can store records in DB" in {
      subscriberDetail.value.futureValue.isRight
    }

    "Can retrieve records from DB by ID" in {
      val result = for {
        subscriberDetailEntity <- subscriberDetail
        subscriberDetail       <- EitherT(subscriberDetailRepository.findBySubscriberId(subscriberDetailEntity.subscriberId))
      } yield {
        subscriberDetail
      }
      result.value.futureValue.isRight
    }
  }

  afterAll()
}