package domain.repository

import scala.concurrent.Future

import domain.model.contract._

trait ContractOfSaleRepository {

  def add(contractOfSale: ContractOfSale): Future[ContractOfSale]

  def findByContractInformationId(contractInformationId: ContractInformation.Id): Future[Option[ContractOfSale]]

}
