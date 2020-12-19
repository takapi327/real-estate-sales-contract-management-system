package domain.repository

import scala.concurrent.Future

import domain.model.contract.Subscriber

trait SubscriberRepository {

  def add(subscriber: Subscriber): Future[Subscriber]

  def findBySubscriberId(subscriberId: Subscriber.Id): Future[Option[Subscriber]]

}
