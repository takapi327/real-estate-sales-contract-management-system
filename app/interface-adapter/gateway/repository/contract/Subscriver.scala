package gateway.repository 

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import library.backend.SlickRepository

import domain.model.contract.Subscriber
import domain.repository.SubscriberRepository

import gateway.dao.SubscriberTable

class SubscriberRepositoryImpl @Inject()(
  implicit ec: ExecutionContext
) extends SubscriberRepository
  with    SlickRepository {

  import api._

  lazy val subscriberTable = TableQuery[SubscriberTable]

  def add(subscriber: Subscriber): Future[Subscriber] = {
    db.run(
      (subscriberTable returning subscriberTable) += subscriber
    )
  }

  def findById(id: Subscriber.Id): Future[Option[Subscriber]] = {
    db.run(
      subscriberTable.filter(_.id === id).result.headOption
    )
  }
}
