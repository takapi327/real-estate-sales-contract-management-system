package gateway.repository 

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import library.backend.SlickRepository

import domain.model.contract.ContractInformation
import domain.repository.ContractInformationRepository

import gateway.dao.ContractInformationTable

class ContractInformationRepositoryImpl @Inject()(
  implicit ec: ExecutionContext
) extends ContractInformationRepository
  with    SlickRepository {

  import api._

  lazy val contractInformationTable = TableQuery[ContractInformationTable]

  def add(contractInformation: ContractInformation): Future[Int] = {
    db.run(
      contractInformationTable += contractInformation
    )
  }

  def findById(id: ContractInformation.Id): Future[Option[ContractInformation]] = {
    db.run(
      contractInformationTable.filter(_.id === id)
        .result.headOption
    )
  }
}
