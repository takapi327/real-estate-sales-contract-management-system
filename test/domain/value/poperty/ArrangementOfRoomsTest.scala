package domain.value.property.arrangementofrooms 

import org.scalatest._
import org.scalatestplus.play._

class ArrangementOfRoomsTest extends PlaySpec {

  "If the floor plan argument is a 3LDK, it is stored in Right" in {
    ArrangementOfRooms("3LDK").isRight mustBe true
  }

  "If the floor plan argument is a 0LDK, it is stored in Left" in {
    ArrangementOfRooms("0LDK").isLeft mustBe true
  }

  "If the floor plan argument is a 9LDK, it is stored in Right" in {
    ArrangementOfRooms("9LDK").isRight mustBe true
  }

  "If the floor plan argument is a 12LDK, it is stored in Right" in {
    ArrangementOfRooms("12LDK").isRight mustBe true
  }

  "If the floor plan argument is a 3DK, it is stored in Right" in {
    ArrangementOfRooms("3DK").isRight mustBe true
  }

  "If the floor plan argument is a 3K, it is stored in Left" in {
    ArrangementOfRooms("3K").isLeft mustBe true
  }

  "If the floor plan argument is a 3, it is stored in Left" in {
    ArrangementOfRooms("3").isLeft mustBe true
  }

  "If the floor plan argument is a LDK, it is stored in Left" in {
    ArrangementOfRooms("LDK").isLeft mustBe true
  }

  "If the floor plan argument is a ldk, it is stored in Left" in {
    ArrangementOfRooms("ldk").isLeft mustBe true
  }
}
