package domain.repository

import scala.concurrent.Future

import domain.model.contract._

trait AgreementRepository {

  def add(agreement: Agreement): Future[Agreement]

  def findById(id: Agreement.Id): Future[Option[Agreement]]

}
