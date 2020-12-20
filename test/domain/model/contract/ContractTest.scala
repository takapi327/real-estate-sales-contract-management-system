package domain.model.contract

import java.time.LocalDate

import org.scalatest._
import org.scalatestplus.play._

import domain.model.company.Employee
import domain.model.property.Property

class ContractTest extends FunSuite {

  test("If you pass the ContractOfSale model arguments correctly, they will be stored in Right") {

    val contractOfSale = for {

      subscriber <- subscriber.toEither
      employee   <- employee.toEither
      property   <- property.toEither

    } yield {

      val contractInformation = ContractInformation.create(
        rawPropertyId = property.id,
        rawContents   = "hogehoge"
      ) 

      ContractOfSale.create(
       rawContractInformationId = contractInformation.id,
       rawSubscriberId          = subscriber.id,
       rawEmployeeId            = employee.id
      )
    }

    assert(
      contractOfSale.isRight
    )
  }

  test("If you pass the ContractOfBuy model arguments correctly, they will be stored in Right") {

    val contractOfBuy = for {

      subscriber <- subscriber.toEither
      employee   <- employee.toEither
      property   <- property.toEither

    } yield {

      val contractInformation = ContractInformation.create(
        rawPropertyId = property.id,
        rawContents   = "hogehoge"
      ) 

      ContractOfBuy.create(
       rawContractInformationId = contractInformation.id,
       rawSubscriberId          = subscriber.id,
       rawEmployeeId            = employee.id
      )
    }

    assert(
      contractOfBuy.isRight
    )
  }

  lazy val subscriber = Subscriber.create(
    rawFirstName   = "test",
    rawLastName    = "テスト",
    rawBirthYear   = 1995,
    rawBirthMonth  = 7,
    rawBirthDay    = 15,
    rawAddress     = "hogehoge",
    rawPhoneNumber = "090-123-4567",
    rawEmail       = "test@ezweb.ne.jp"
  )

  lazy val employee = Employee.create(
    rawFirstName     = "test",
    rawLastName      = "テスト",
    rawBirthYear   = 1995,
    rawBirthMonth  = 7,
    rawBirthDay    = 15,
    rawAddress       = "hogehoge",
    rawPhoneNumber   = "090-1234-5678",
    rawEmail         = "test@ezweb.ne.jp",
    rawLicenseNumber = None
  )

  lazy val property = Property.create(
    rawAddress            = "hogehoge",
    rawTypeCode           = 2,
    rawPrice              = "20,000,000",
    rawDateBuilt          = LocalDate.now(),
    rawStructureCode      = 4,
    rawArrangementOfRooms = "3LDK"
  )

}
