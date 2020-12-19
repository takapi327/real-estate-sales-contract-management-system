package domain.repository

import scala.concurrent.Future

import domain.model.property.Property

trait PropertyRepository {

  def add(property: Property): Future[Property]

  def findById(id: Property.Id): Future[Option[Property]]

}
