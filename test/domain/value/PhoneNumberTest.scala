package domain.value.common.phone

import org.scalatest._
import org.scalatestplus.play._

class PhoneNumberTest extends FunSuite {

  test("If the phone number is 09012345678, it is stored in the Right.") {
    assert(PhoneNumber("09012345678").isRight)
  }

  test("If the phone number is 0798123456, it is stored in the Right.") {
    assert(PhoneNumber("0798123456").isRight)
  }

  test("If the phone number is test, it is stored in the Left.") {
    assert(PhoneNumber("test").isLeft)
  }

  test("If the phone number is テスト, it is stored in the Left.") {
    assert(PhoneNumber("テスト").isLeft)
  }
}
