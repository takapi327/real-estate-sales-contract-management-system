package domain.model.customer

import java.util.UUID

import org.scalatestplus.play._

class SubscriberDetailTest extends PlaySpec {

  "If you pass the SubscriberDetail model arguments correctly, they will be stored in Valid" in {
    SubscriberDetail.create(
      rawSubscriberId = Subscriber.Id(UUID.fromString("1ab00caa-c323-48af-a831-3bfcdb52d16d")),
      rawBirthYear    = 1995,
      rawBirthMonth   = 7,
      rawBirthDay     = 15,
      rawAddress      = "hogehoge",
      rawPhoneNumber  = "0901234567",
      rawEmail        = "test@ezweb.ne.jp"
    ).isValid mustBe true
  }

}