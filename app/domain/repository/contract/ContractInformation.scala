package domain.repository

import scala.concurrent.Future

import domain.model.contract._

trait ContractInformationRepository {

  def add(contractInformation: ContractInformation): Future[Int]

  def findById(id: ContractInformation.Id): Future[Option[ContractInformation]]

}
