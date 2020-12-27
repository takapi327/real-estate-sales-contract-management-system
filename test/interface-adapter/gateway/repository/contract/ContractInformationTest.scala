package gateway.repository 

import java.util.UUID

import org.scalatest._
import org.scalatestplus.play._

import domain.model.contract.ContractInformation
import domain.model.property.Property

import library.backend.SlickRepositorySpec
import gateway.dao.ContractInformationTable

class ContractInformationRepositorySpec extends SlickRepositorySpec {

  private val repository = fakeApplication.injector.instanceOf[ContractInformationRepositoryImpl]

  afterAll()

  "ContractInformationRepositoryImpl Test" should {

    "Can store records in DB" in {

      val contractInformation = ContractInformation.create(
        rawPropertyId = Property.Id(UUID.fromString("2d407609-4ccd-408e-bd9e-d9f13b7757a8")),
        rawContents   = "売買契約",
      )

      repository.add(contractInformation).futureValue mustBe 1

    }

    "Can retrieve records from DB by ID" in {
      val contractInformationId: ContractInformation.Id = ContractInformation.Id(UUID.fromString("faece202-58aa-4690-bd3f-de8b70d16f50"))
      (repository.findById(contractInformationId).futureValue match {
        case Some(e) => true
        case None    => false
      }) mustBe true
    }
  }
}
