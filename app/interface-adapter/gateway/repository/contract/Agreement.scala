package gateway.repository 

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import library.backend.SlickRepository

import domain.model.contract.Agreement
import domain.repository.AgreementRepository

import gateway.dao.AgreementTable

class AgreementRepositoryImpl @Inject()(
  implicit ec: ExecutionContext
) extends AgreementRepository
  with    SlickRepository {

  import api._

  lazy val agreementTable = TableQuery[AgreementTable]

  def add(agreement: Agreement): Future[Agreement] = {
    db.run(
      (agreementTable returning agreementTable) += agreement
    )
  }

  def findById(id: Agreement.Id): Future[Option[Agreement]] = {
    db.run(
      agreementTable.filter(_.id === id)
        .result.headOption
    )
  }
}
