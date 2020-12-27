package domain.model.contract

import java.time.LocalDate

import org.scalatest._
import org.scalatestplus.play._

import cats.data.ValidatedNel  
import cats.data.Validated.{Invalid, Valid}
import cats.implicits._        
                               
import domain.model.property._

class PaymentSlipTest extends PlaySpec {

  "If you pass the PaymentSlip model arguments correctly, they will be stored in Valid" in {

    val property = Property.create(
      rawAddress            = "hogehoge",
      rawTypeCode           = 2,
      rawPrice              = "200,000,000,000",
      rawDateBuilt          = LocalDate.now(),
      rawStructureCode      = 4,
      rawArrangementOfRooms = "3LDK"
    )

    (for {
      property            <- property.toEither
      contractInformation =  ContractInformation.create(
        rawPropertyId = property.id,
        rawContents   = "売買契約"
      )
      paymentSlip <- PaymentSlip.create(
        rawInfomationId = contractInformation.id,
        rawItemName     = "手数料",
        rawPrice        = "200,000,000,000,000"
      ).toEither
    } yield {
      paymentSlip
    }).isRight mustBe true
  }

}
