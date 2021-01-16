package gateway.repository

import domain.model.customer.Subscriber

import cats.data.NonEmptyList

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import library.backend.SlickRepository
import domain.repository.SubscriberRepository
import gateway.dao.customer.SubscriberTable

class SubscriberRepositoryImpl @Inject()(
  implicit ec: ExecutionContext
) extends SubscriberRepository
  with    SlickRepository {

  import api._
  import mapping._

  lazy val subscriberTable = TableQuery[SubscriberTable]

  def add(subscriber: Subscriber): Future[Either[NonEmptyList[Any], Subscriber]]= {
    db.run(
      subscriberTable += subscriber
    ).map(_ => Right(subscriber)).recover(error => Left(NonEmptyList.one(error)))
  }

  def findById(id: Subscriber.Id): Future[Either[NonEmptyList[Any], Subscriber]] = {
    db.run(
      subscriberTable.filter(_.id === id).result.headOption
    ).map(v => Right(v.get)).recover(error => Left(NonEmptyList.one(error)))
  }
}