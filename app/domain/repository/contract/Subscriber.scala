package domain.repository

import domain.model.customer.Subscriber

import scala.concurrent.Future

trait SubscriberRepository {

  def add(subscriber: Subscriber): Future[Int]

  def findById(id: Subscriber.Id): Future[Option[Subscriber]]

}
