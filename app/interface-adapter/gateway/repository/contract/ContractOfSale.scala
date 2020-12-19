package gateway.repository 

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import library.backend.SlickRepository

import domain.model.contract.{ContractOfSale, ContractInformation}
import domain.repository.ContractOfSaleRepository

import gateway.dao.ContractOfSaleTable

class ContractOfSaleRepositoryImpl @Inject()(
  implicit ec: ExecutionContext
) extends ContractOfSaleRepository
  with    SlickRepository {

  import api._

  lazy val contractOfSaleTable = TableQuery[ContractOfSaleTable]

  def add(contractOfSale: ContractOfSale): Future[ContractOfSale] = {
    db.run(
      (contractOfSaleTable returning contractOfSaleTable) += contractOfSale
    )
  }

  def findByContractInformationId(
    contractInformationId: ContractInformation.Id
  ): Future[Option[ContractOfSale]] = {
    db.run(
      contractOfSaleTable.filter(_.contractInformationId === contractInformationId)
        .result.headOption
    )
  }
}
