package domain.value.property

import org.scalatest._
import org.scalatestplus.play._

class PriceTest extends FunSuite {
  test("If the amount is 1, it is stored in Right") {
    assert(Price("1").isRight)
  }

  test("If the amount is 100, it is stored in Right") {
    assert(Price("100").isRight)
  }

  test("If the amount is 10, it is stored in Right") {
    assert(Price("10").isRight)
  }

  test("If the amount is 1,000, it is stored in Right") {
    assert(Price("1,000").isRight)
  }

  test("If the amount is 1,000,000,000,000, it is stored in Right") {
    assert(Price("1,000,000,000,000").isRight)
  }

  test("If the amount is 1000000000000, it is stored in Left") {
    assert(Price("1000000000000").isLeft)
  }

  test("If the amount is test, it is stored in Left") {
    assert(Price("test").isLeft)
  }
}
