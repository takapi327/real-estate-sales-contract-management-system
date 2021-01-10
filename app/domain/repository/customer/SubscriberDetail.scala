package domain.repository

import domain.model.customer.{Subscriber, SubscriberDetail}

import scala.concurrent.Future

trait SubscriberDetailRepository {

  def add(subscriberDetail: SubscriberDetail): Future[Int]

  def findBySubscriberId(subscriberId: Subscriber.Id): Future[Option[SubscriberDetail]]

}