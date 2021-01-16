package domain.repository

import cats.data.NonEmptyList

import domain.model.customer.{Subscriber, SubscriberDetail}

import scala.concurrent.Future

trait SubscriberDetailRepository {

  def add(subscriberDetail: SubscriberDetail): Future[Either[NonEmptyList[Any], SubscriberDetail]]

  def findBySubscriberId(subscriberId: Subscriber.Id): Future[Either[NonEmptyList[Any], SubscriberDetail]]

}