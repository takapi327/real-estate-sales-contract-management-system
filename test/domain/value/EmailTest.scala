package domain.value.common.email

import org.scalatest._
import org.scalatestplus.play._

class EmailTest extends FunSuite {

  test("If the email address is test@ezweb.ne.jp, it will be stored in Right") {
    assert(Email("test@ezweb.ne.jp").isRight)
  }

  test("If the email address is test@ezweb.jp, it will be stored in Right") {
    assert(Email("test@ezweb.jp").isRight)
  }

  test("If the email address is test@ezweb, it will be stored in Left") {
    assert(Email("test@ezweb").isLeft)
  }

  test("If the email address is testezweb.ne.jp, it will be stored in Left") {
    assert(Email("testezweb.ne.jp").isLeft)
  }

  test("If the email address is @ezweb, it will be stored in Left") {
    assert(Email("@ezweb").isLeft)
  }

  test("if the email address is @, it will be stored in left") {
    assert(Email("@").isLeft)
  }

  test("if the email address is Empty, it will be stored in left") {
    assert(Email("").isLeft)
  }

  test("if the email address is テスト@ezweb.ne.jp, it will be stored in left") {
    assert(Email("テスト@ezweb.ne.jp").isLeft)
  }
}
