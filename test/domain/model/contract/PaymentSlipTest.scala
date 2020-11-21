package domain.model.contract

import org.scalatest._
import org.scalatestplus.play._

import cats.data.ValidatedNel  
import cats.data.Validated.{Invalid, Valid}
import cats.implicits._        
                               
import domain.model.property.Property
import domain.value.property.price._

class PaymentSlipTest extends FunSuite {

  test("If you pass the PaymentSlip model arguments correctly, they will be stored in Valid") {

    val property = Property.create(
      rawAddress            = "hogehoge",
      rawTypeCode           = 2,
      rawPrice              = "200,000,000,000",
      rawAge                = 59,
      rawStructureCode      = 4,
      rawArrangementOfRooms = "3LDK"
    )

    assert(
      (for {
        property            <- property.toEither
        contractInformation =  ContractInformation.create(
          rawPropertyId = property.propertyId,
          rawContents   = "売買契約"
        )
        paymentSlip <- PaymentSlip.create(
          rawInfomationId = contractInformation.id,
          rawItemName     = "手数料",
          rawPrice        = "200,000,000,000,000"
        ).toEither
      } yield {
        paymentSlip
      }).isRight
    )
  }

}
