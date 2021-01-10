package domain.model.contract

import domain.model.company._
import domain.model.customer._

case class ContractOfSale(
  contractInformation: ContractInformation.Id,
  subscriberId:        Subscriber.Id,
  employeeId:          Employee.Id
)

object ContractOfSale {

  def create(
    rawContractInformationId: ContractInformation.Id,
    rawSubscriberId:          Subscriber.Id,
    rawEmployeeId:            Employee.Id
  ): ContractOfSale = {
    ContractOfSale(
      contractInformation = rawContractInformationId,
      subscriberId        = rawSubscriberId,
      employeeId          = rawEmployeeId
    )
  }
}
