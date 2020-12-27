package domain.repository

import scala.concurrent.Future

import domain.model.contract.Subscriber

trait SubscriberRepository {

  def add(subscriber: Subscriber): Future[Int]

  def findById(id: Subscriber.Id): Future[Option[Subscriber]]

}
