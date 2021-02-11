package domain.repository

import cats.data.NonEmptyList

import domain.model.customer.Subscriber

import scala.concurrent.Future

trait SubscriberRepository {

  def add(subscriber: Subscriber): Future[Either[NonEmptyList[Any], Subscriber]]

  def findById(id: Subscriber.Id): Future[Either[NonEmptyList[Any], Subscriber]]

}