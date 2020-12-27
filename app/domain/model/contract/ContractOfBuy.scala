package domain.model.contract

import domain.model.company._

case class ContractOfBuy(
  contractInformationId: ContractInformation.Id,
  subscriberId:          Subscriber.Id,
  employeeId:            Employee.Id
)

object ContractOfBuy {

  def create(
    rawContractInformationId: ContractInformation.Id,
    rawSubscriberId:          Subscriber.Id,
    rawEmployeeId:            Employee.Id
  ): ContractOfBuy = {
    ContractOfBuy(
      contractInformationId = rawContractInformationId,
      subscriberId          = rawSubscriberId,
      employeeId            = rawEmployeeId
    )
  }
}
