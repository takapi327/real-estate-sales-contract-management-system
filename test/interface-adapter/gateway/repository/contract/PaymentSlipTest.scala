package gateway.repository 

import java.util.UUID

import cats.data.Validated.{Invalid, Valid}

import domain.model.contract.{PaymentSlip, ContractInformation}

import library.backend.SlickRepositorySpec

class PaymentSlipRepositorySpec extends SlickRepositorySpec {

  private val repository = fakeApplication.injector.instanceOf[PaymentSlipRepositoryImpl]

  afterAll()

  "PaymentSlipRepositoryImpl Test" should {

    "Can store records in DB" in {

      val paymentSlip = PaymentSlip.create(
        rawInfomationId = ContractInformation.Id(UUID.fromString("faece202-58aa-4690-bd3f-de8b70d16f50")),
        rawItemName     = "手数料",
        rawPrice        = "200,000,000,000,000"
      )

      paymentSlip match {
        case Valid(v)   => repository.add(v).futureValue mustBe 1
        case Invalid(v) => fail("Not Create Employee")
      }

    }

    "Can retrieve records from DB by ID" in {
      val paymentSlipId: PaymentSlip.Id = PaymentSlip.Id(UUID.fromString("123b1c46-fe35-44a8-9a81-5210ac5d7fdc"))
      (repository.findById(paymentSlipId).futureValue match {
        case Some(e) => true
        case None    => false
      }) mustBe true
    }
  }
}
