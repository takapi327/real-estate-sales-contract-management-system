package gateway.repository

import domain.model.customer.{Subscriber, SubscriberDetail}

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

  def add(subscriberDetail: SubscriberDetail): Future[Int] = {
    db.run(
      subscriberDetailTable += subscriberDetail
    )
  }

  def findBySubscriberId(subscriberId: Subscriber.Id): Future[Option[SubscriberDetail]] = {
    db.run(
      subscriberDetailTable.filter(_.subscriberId === subscriberId).result.headOption
    )
  }
}