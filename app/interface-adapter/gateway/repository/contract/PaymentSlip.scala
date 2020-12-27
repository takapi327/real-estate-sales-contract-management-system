package gateway.repository 

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import library.backend.SlickRepository

import domain.model.contract.PaymentSlip
import domain.repository.PaymentSlipRepository

import gateway.dao.PaymentSlipTable

class PaymentSlipRepositoryImpl @Inject()(
  implicit ec: ExecutionContext
) extends PaymentSlipRepository
  with    SlickRepository {

  import api._
  import mapping._

  lazy val paymentSlipTable = TableQuery[PaymentSlipTable]

  def add(paymentSlip: PaymentSlip): Future[Int] = {
    db.run(
      paymentSlipTable += paymentSlip
    )
  }

  def findById(id: PaymentSlip.Id): Future[Option[PaymentSlip]] = {
    db.run(
      paymentSlipTable.filter(_.id === id)
        .result.headOption
    )
  }
}
