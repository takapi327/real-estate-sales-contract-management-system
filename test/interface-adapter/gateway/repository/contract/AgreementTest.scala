package gateway.repository 

import java.util.UUID

import domain.model.contract.{Agreement, ContractInformation}

import library.backend.SlickRepositorySpec

class AgreementRepositorySpec extends SlickRepositorySpec {

  private val repository = fakeApplication.injector.instanceOf[AgreementRepositoryImpl]

  afterAll()

  "AgreementRepositoryImpl Test" should {

    "Can store records in DB" in {

      val agreement = Agreement.create(
        rawInfomationId = ContractInformation.Id(UUID.fromString("faece202-58aa-4690-bd3f-de8b70d16f50")),
        rawName         = "売買契約",
      )

      repository.add(agreement).futureValue mustBe 1

    }

    "Can retrieve records from DB by ID" in {
      val agreementId: Agreement.Id = Agreement.Id(UUID.fromString("6885c7e8-8b2a-4f19-93e0-6c6afe88fa08"))
      (repository.findById(agreementId).futureValue match {
        case Some(e) => true
        case None    => false
      }) mustBe true
    }
  }
}
