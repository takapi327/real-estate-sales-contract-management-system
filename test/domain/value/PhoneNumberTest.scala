package domain.value.common.phone

import org.scalatest._
import org.scalatestplus.play._

class PhoneNumberTest extends PlaySpec {

  "If the phone number is 09012345678, it is stored in the Right." in {
    PhoneNumber("09012345678").isRight mustBe true
  }

  "If the phone number is 0798123456, it is stored in the Right." in {
    PhoneNumber("0798123456").isRight mustBe true
  }

  "If the phone number is test, it is stored in the Left." in {
    PhoneNumber("test").isLeft mustBe true
  }

  "If the phone number is テスト, it is stored in the Left." in {
    PhoneNumber("テスト").isLeft mustBe true
  }
}
