package domain.value.common.name

import org.scalatest._
import org.scalatestplus.play._

class NameTest extends PlaySpec {

  "If the first name is 4 characters, it will be stored in Right." in {
    FirstName("test").isRight mustBe true
  }

  "If the first name is more than 17 characters, it is stored in Left." in {
    FirstName("hogehogehugahuga!").isLeft mustBe true
  }

  "If the first name is empty, it is stored in Left." in {
    FirstName("").isLeft mustBe true
  }

  "If the last name is 4 characters, it will be stored in Right." in {
    LastName("test").isRight mustBe true
  }

  "If the last name is more than 17 characters, it is stored in Left." in {
    LastName("hogehogehugahuga!").isLeft mustBe true
  }

  "If the last name is empty, it is stored in Left." in {
    LastName("").isLeft mustBe true
  }
}
