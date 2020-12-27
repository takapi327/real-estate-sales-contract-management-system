package domain.value.property.price

import org.scalatest._
import org.scalatestplus.play._

class PriceTest extends PlaySpec {
  "If the amount is 1, it is stored in Right" in {
    Price("1").isRight mustBe true
  }

  "If the amount is 100, it is stored in Right" in {
    Price("100").isRight mustBe true
  }

  "If the amount is 10, it is stored in Right" in {
    Price("10").isRight mustBe true
  }

  "If the amount is 1,000, it is stored in Right" in {
    Price("1,000").isRight mustBe true
  }

  "If the amount is 1,000,000,000,000, it is stored in Right" in {
    Price("1,000,000,000,000").isRight mustBe true
  }

  "If the amount is 1000000000000, it is stored in Left" in {
    Price("1000000000000").isRight mustBe false
  }

  "If the amount is test, it is stored in Left" in {
    Price("test").isRight mustBe false
  }
}
