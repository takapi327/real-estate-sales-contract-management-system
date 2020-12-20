package domain.value.property.arrangementofrooms 

import org.scalatest._
import org.scalatestplus.play._

class ArrangementOfRoomsTest extends FunSuite {

  test("If the floor plan argument is a 3LDK, it is stored in Right") {
    assert(ArrangementOfRooms("3LDK").isRight)
  }

  test("If the floor plan argument is a 0LDK, it is stored in Left") {
    assert(ArrangementOfRooms("0LDK").isLeft)
  }

  test("If the floor plan argument is a 9LDK, it is stored in Right") {
    assert(ArrangementOfRooms("9LDK").isRight)
  }

  test("If the floor plan argument is a 12LDK, it is stored in Right") {
    assert(ArrangementOfRooms("12LDK").isRight)
  }

  test("If the floor plan argument is a 3DK, it is stored in Right") {
    assert(ArrangementOfRooms("3DK").isRight)
  }

  test("If the floor plan argument is a 3K, it is stored in Left") {
    assert(ArrangementOfRooms("3K").isLeft)
  }

  test("If the floor plan argument is a 3, it is stored in Left") {
    assert(ArrangementOfRooms("3").isLeft)
  }

  test("If the floor plan argument is a LDK, it is stored in Left") {
    assert(ArrangementOfRooms("LDK").isLeft)
  }

  test("If the floor plan argument is a ldk, it is stored in Left") {
    assert(ArrangementOfRooms("ldk").isLeft)
  }
}
