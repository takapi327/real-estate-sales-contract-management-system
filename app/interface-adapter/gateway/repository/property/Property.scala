package gateway.repository 

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import library.backend.SlickRepository

import domain.model.property.Property
import domain.repository.PropertyRepository

import gateway.dao.property.PropertyTable

class PropertyRepositoryImpl @Inject()(
  implicit ec: ExecutionContext
) extends PropertyRepository
  with    SlickRepository {

  import api._

  lazy val propertyTable = TableQuery[PropertyTable]

  def add(property: Property): Future[Int] = {
    db.run(
      propertyTable += property
    )
  }

  def findById(id: Property.Id): Future[Option[Property]] = {
    db.run(
      propertyTable.filter(_.id === id).result.headOption
    )
  }
}
