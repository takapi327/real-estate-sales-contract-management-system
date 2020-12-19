package domain.repository

import scala.concurrent.Future

import domain.model.contract._
import domain.model.company._

trait ContractOfBuyRepository {

  def add(contractOfBuy: ContractOfBuy): Future[ContractOfBuy]

  def findByContractInformationId(contractInformationId: ContractInformation.Id): Future[Option[ContractOfBuy]]

}
