package domain.value.common

import org.scalatest._
import org.scalatestplus.play._

class AgeTest extends FunSuite {

  test("If you pass 1 for the Age argument, it becomes Right") {
    assert(Age(1).isRight)
  }

  test("If you pass 0 for the Age argument, it becomes Left") {
    assert(Age(0).isLeft)
  }

  test("If you pass 151 for the Age argument, it becomes Left") {
    assert(Age(151).isLeft)
  }

  test("If you pass 150 for the Age argument, it becomes Right") {
    assert(Age(150).isRight)
  }
}
