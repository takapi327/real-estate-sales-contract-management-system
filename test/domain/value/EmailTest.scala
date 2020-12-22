package domain.value.common.email

import org.scalatest._
import org.scalatestplus.play._

class EmailTest extends PlaySpec {

  "If the email address is test@ezweb.ne.jp, it will be stored in Right" in {
    Email("test@ezweb.ne.jp").isRight mustBe true
  }

  "If the email address is test@ezweb.jp, it will be stored in Right" in {
    Email("test@ezweb.jp").isRight mustBe true
  }

  "If the email address is test@ezweb, it will be stored in Left" in {
    Email("test@ezweb").isLeft mustBe true
  }

  "If the email address is testezweb.ne.jp, it will be stored in Left" in {
    Email("testezweb.ne.jp").isLeft mustBe true
  }

  "If the email address is @ezweb, it will be stored in Left" in {
    Email("@ezweb").isLeft mustBe true
  }

  "if the email address is @, it will be stored in left" in {
    Email("@").isLeft mustBe true
  }

  "if the email address is Empty, it will be stored in left" in {
    Email("").isLeft mustBe true
  }

  "if the email address is テスト@ezweb.ne.jp, it will be stored in left" in {
    Email("テスト@ezweb.ne.jp").isLeft mustBe true
  }
}
