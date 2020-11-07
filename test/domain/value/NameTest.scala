package domain.value.common.name

import org.scalatest._
import org.scalatestplus.play._

class NameTest extends FunSuite {

  test("If the first name is 4 characters, it will be stored in Right.") {
    assert(FirstName("test").isRight)
  }

  test("If the first name is more than 17 characters, it is stored in Left.") {
    assert(FirstName("hogehogehugahuga!").isLeft)
  }

  test("If the first name is empty, it is stored in Left.") {
    assert(FirstName("").isLeft)
  }

  test("If the last name is 4 characters, it will be stored in Right.") {
    assert(LastName("test").isRight)
  }

  test("If the last name is more than 17 characters, it is stored in Left.") {
    assert(LastName("hogehogehugahuga!").isLeft)
  }

  test("If the last name is empty, it is stored in Left.") {
    assert(LastName("").isLeft)
  }
}
