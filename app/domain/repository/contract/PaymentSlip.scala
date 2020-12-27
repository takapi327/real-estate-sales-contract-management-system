package domain.repository

import scala.concurrent.Future

import domain.model.contract._

trait PaymentSlipRepository {

  def add(paymentSlip: PaymentSlip): Future[Int]

  def findById(id: PaymentSlip.Id): Future[Option[PaymentSlip]]

}
