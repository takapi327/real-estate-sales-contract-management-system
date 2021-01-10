package gateway.repository 

import java.util.UUID

import org.scalatest._
import org.scalatestplus.play._

import domain.model.contract.{ContractOfSale, ContractInformation}
import domain.model.company.Employee

import library.backend.SlickRepositorySpec
import gateway.dao.ContractOfSaleTable

class ContractOfSaleRepositorySpec extends SlickRepositorySpec {

  private val repository = fakeApplication.injector.instanceOf[ContractOfSaleRepositoryImpl]

  afterAll()

  "ContractOfSaleRepositoryImpl Test" should {

    "Can store records in DB" in {

      val contractOfSale = ContractOfSale.create(
        rawContractInformationId = ContractInformation.Id(UUID.fromString("faece202-58aa-4690-bd3f-de8b70d16f50")),
        rawSubscriberId          = Subscriber.Id(UUID.fromString("8aa1cff5-58e3-431c-92ed-9ddaa2fd63fb")),
        rawEmployeeId            = Employee.Id(UUID.fromString("f069d88d-b622-4b5c-98e4-0538e04baf34"))
      )

      repository.add(contractOfSale).futureValue mustBe 1
    }

    "Can retrieve records from DB by ID" in {
      val contractInformationId: ContractInformation.Id = ContractInformation.Id(UUID.fromString("faece202-58aa-4690-bd3f-de8b70d16f50"))
      (repository.findByContractInformationId(contractInformationId).futureValue match {
        case Some(e) => true
        case None    => false
      }) mustBe true
    }
  }
}
