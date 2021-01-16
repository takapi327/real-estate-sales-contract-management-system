package gateway.repository

import domain.model.customer.{Subscriber, SubscriberDetail}

import cats.data.NonEmptyList

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import library.backend.SlickRepository
import domain.repository.SubscriberDetailRepository
import gateway.dao.customer.SubscriberDetailTable

class SubscriberDetailRepositoryImpl @Inject()(
  implicit ec: ExecutionContext
) extends SubscriberDetailRepository
  with    SlickRepository {

  import api._
  import mapping._

  lazy val subscriberDetailTable = TableQuery[SubscriberDetailTable]

  def add(subscriberDetail: SubscriberDetail): Future[Either[NonEmptyList[Any], SubscriberDetail]] = {
    db.run(
      subscriberDetailTable += subscriberDetail
    ).map(_ => Right(subscriberDetail)).recover(error => Left(NonEmptyList.one(error)))
  }

  def findBySubscriberId(subscriberId: Subscriber.Id): Future[Either[NonEmptyList[Any], SubscriberDetail]] = {
    db.run(
      subscriberDetailTable.filter(_.subscriberId === subscriberId).result.headOption
    ).map(v => Right(v.get)).recover(error => Left(NonEmptyList.one(error)))
  }
}