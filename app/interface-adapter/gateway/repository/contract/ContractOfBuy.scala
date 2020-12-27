package gateway.repository 

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import library.backend.SlickRepository

import domain.model.contract.{ContractOfBuy, ContractInformation}
import domain.repository.ContractOfBuyRepository

import gateway.dao.ContractOfBuyTable

class ContractOfBuyRepositoryImpl @Inject()(
  implicit ec: ExecutionContext
) extends ContractOfBuyRepository
  with    SlickRepository {

  import api._

  lazy val contractOfBuyTable = TableQuery[ContractOfBuyTable]

  def add(contractOfBuy: ContractOfBuy): Future[Int] = {
    db.run(
      contractOfBuyTable += contractOfBuy
    )
  }

  def findByContractInformationId(
    contractInformationId: ContractInformation.Id
  ): Future[Option[ContractOfBuy]] = {
    db.run(
      contractOfBuyTable.filter(_.contractInformationId === contractInformationId)
        .result.headOption
    )
  }
}
