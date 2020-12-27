package domain.repository

import scala.concurrent.Future

import domain.model.contract._

trait ContractOfSaleRepository {

  def add(contractOfSale: ContractOfSale): Future[Int]

  def findByContractInformationId(contractInformationId: ContractInformation.Id): Future[Option[ContractOfSale]]

}
