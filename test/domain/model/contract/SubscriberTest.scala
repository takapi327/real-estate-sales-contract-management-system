package domain.model.contract

import org.scalatest._
import org.scalatestplus.play._

class SubscriberTest extends FunSuite {

  test("If you pass the Subscriber model arguments correctly, they will be stored in Valid") {
    assert(
      Subscriber.create(
        rawFirstName   = "test",
        rawLastName    = "テスト",
        rawBirthYear   = 1995,
        rawBirthMonth  = 7,
        rawBirthDay    = 15,
        rawAddress     = "hogehoge",
        rawPhoneNumber = "0901234567",
        rawEmail       = "test@ezweb.ne.jp"
      ).isValid
    )
  }

}
