package domain.value.property

import org.scalatest._
import org.scalatestplus.play._

class StructureTest extends PlaySpec {

  /**
   * WOODWORK Test
   */
  "The WOODWORK object upperName is the same as the specified string" in {
    Structure.WOODWORK.upperName mustBe "WOODWORK"
  }

  "The WOODWORK object upperName is not the same as the specified string" in {
    Structure.WOODWORK.upperName must not be "LIGHTWEIGHT_STEEL_CONSTRUCTION"
  }

  "The WOODWORK object lowerName is the same as the specified string" in {
    Structure.WOODWORK.lowerName mustBe "woodwork"
  }

  "The WOODWORK object lowerName is not the same as the specified string" in {
    Structure.WOODWORK.lowerName must not be "lightweight_steel_construction"
  }

  "WOODWORK code will be the same as the specified number" in {
    Structure.WOODWORK.code mustBe 0
  }

  "WOODWORK code will not be the same as the specified number" in {
    Structure.WOODWORK.code must not be 1
  }

  "The WOODWORK object nameSet is the same as the specified name set" in {
    Structure.WOODWORK.nameSet mustBe ("WOODWORK", "woodwork", "木造")
  }

  "The WOODWORK object detailName is not the same as the specified name set" in {
    Structure.WOODWORK.nameSet must not be ("LIGHTWEIGHT_STEEL_CONSTRUCTION", "lightweight_steel_construction", "軽量鉄骨造")
  }

  "The Type obtained from the Type search is the same as the specified WOODWORK" in {
    Structure.find(0) mustBe Structure.WOODWORK
  }

  "The Type obtained from the Type search is not the same as the specified WOODWORK" in {
    Structure.find(1) must not be Structure.WOODWORK
  }

  /**
   * LIGHTWEIGHT_STEEL_CONSTRUCTION Test
   */
  "The LIGHTWEIGHT_STEEL_CONSTRUCTION object upperName is the same as the specified string" in {
    Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.upperName mustBe "LIGHTWEIGHT_STEEL_CONSTRUCTION"
  }

  "The LIGHTWEIGHT_STEEL_CONSTRUCTION object upperName is not the same as the specified string" in {
    Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.upperName must not be "HEAVY_STEEL_CONSTRUCTION"
  }

  "The LIGHTWEIGHT_STEEL_CONSTRUCTION object lowerName is the same as the specified stwring" in {
    Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.lowerName mustBe "lightweight_steel_construction"
  }

  "The LIGHTWEIGHT_STEEL_CONSTRUCTION object lowerName is not the same as the specified string" in {
    Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.lowerName must not be "heavy_steel_construction"
  }

  "LIGHTWEIGHT_STEEL_CONSTRUCTION code will be the same as the specified number" in {
    Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.code mustBe 1
  }

  "LIGHTWEIGHT_STEEL_CONSTRUCTION code will not be the same as the specified number" in {
    Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.code must not be 2
  }

  "The LIGHTWEIGHT_STEEL_CONSTRUCTION object nameSet is the same as the specified name set" in {
    Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.nameSet mustBe ("LIGHTWEIGHT_STEEL_CONSTRUCTION", "lightweight_steel_construction", "軽量鉄骨造")
  }

  "The LIGHTWEIGHT_STEEL_CONSTRUCTION object detailName is not the same as the specified name set" in {
    Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.nameSet must not be ("HEAVY_STEEL_CONSTRUCTION", "heavy_steel_construction", "重量鉄骨造")
  }

  "The Type obtained from the Type search is the same as the specified LIGHTWEIGHT_STEEL_CONSTRUCTION" in {
    Structure.find(1) mustBe Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION
  }

  "The Type obtained from the Type search is not the same as the specified LIGHTWEIGHT_STEEL_CONSTRUCTION" in {
    Structure.find(2) must not be Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION
  }

  /**
   * HEAVY_STEEL_CONSTRUCTION Test
   */
  /*
  test("The HEAVY_STEEL_CONSTRUCTION object upperName is the same as the specified string") {
    assert(Structure.HEAVY_STEEL_CONSTRUCTION.upperName == "HEAVY_STEEL_CONSTRUCTION")
  }

  test("The HEAVY_STEEL_CONSTRUCTION object upperName is not the same as the specified string") {
    assert(Structure.HEAVY_STEEL_CONSTRUCTION.upperName != "REINFORCED_CONCRETE_CONSTRUCTION")
  }

  test("The HEAVY_STEEL_CONSTRUCTION object lowerName is the same as the specified stwring") {
    assert(Structure.HEAVY_STEEL_CONSTRUCTION.lowerName == "heavy_steel_construction")
  }

  test("The HEAVY_STEEL_CONSTRUCTION object lowerName is not the same as the specified string") {
    assert(Structure.HEAVY_STEEL_CONSTRUCTION.lowerName != "reinforced_concrete_construction")
  }

  test("HEAVY_STEEL_CONSTRUCTION code will be the same as the specified number") {
    assert(Structure.HEAVY_STEEL_CONSTRUCTION.code == 2)
  }

  test("HEAVY_STEEL_CONSTRUCTION code will not be the same as the specified number") {
    assert(Structure.HEAVY_STEEL_CONSTRUCTION.code != 3)
  }

  test("The HEAVY_STEEL_CONSTRUCTION object nameSet is the same as the specified name set") {
    assert(Structure.HEAVY_STEEL_CONSTRUCTION.nameSet == ("HEAVY_STEEL_CONSTRUCTION", "heavy_steel_construction", "重量鉄骨造"))
  }

  test("The HEAVY_STEEL_CONSTRUCTION object detailName is not the same as the specified name set") {
    assert(Structure.HEAVY_STEEL_CONSTRUCTION.nameSet != ("REINFORCED_CONCRETE_CONSTRUCTION", "reinforced_concrete_construction", "鉄筋コンクリート造"))
  }

  test("The Type obtained from the Type search is the same as the specified HEAVY_STEEL_CONSTRUCTION") {
    assert(Structure.find(2) == Structure.HEAVY_STEEL_CONSTRUCTION)
  }

  test("The Type obtained from the Type search is not the same as the specified HEAVY_STEEL_CONSTRUCTION") {
    assert(Structure.find(3) != Structure.HEAVY_STEEL_CONSTRUCTION)
  }
  */

  /**
   * REINFORCED_CONCRETE_CONSTRUCTION Test
   */
  /*
  test("The REINFORCED_CONCRETE_CONSTRUCTION object upperName is the same as the specified string") {
    assert(Structure.REINFORCED_CONCRETE_CONSTRUCTION.upperName == "REINFORCED_CONCRETE_CONSTRUCTION")
  }

  test("The REINFORCED_CONCRETE_CONSTRUCTION object upperName is not the same as the specified string") {
    assert(Structure.REINFORCED_CONCRETE_CONSTRUCTION.upperName != "STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION")
  }

  test("The REINFORCED_CONCRETE_CONSTRUCTION object lowerName is the same as the specified stwring") {
    assert(Structure.REINFORCED_CONCRETE_CONSTRUCTION.lowerName == "reinforced_concrete_construction")
  }

  test("The REINFORCED_CONCRETE_CONSTRUCTION object lowerName is not the same as the specified string") {
    assert(Structure.REINFORCED_CONCRETE_CONSTRUCTION.lowerName != "steel_framed_reinfoced_concrete_construction")
  }

  test("REINFORCED_CONCRETE_CONSTRUCTION code will be the same as the specified number") {
    assert(Structure.REINFORCED_CONCRETE_CONSTRUCTION.code == 3)
  }

  test("REINFORCED_CONCRETE_CONSTRUCTION code will not be the same as the specified number") {
    assert(Structure.REINFORCED_CONCRETE_CONSTRUCTION.code != 4)
  }

  test("The REINFORCED_CONCRETE_CONSTRUCTION object nameSet is the same as the specified name set") {
    assert(Structure.REINFORCED_CONCRETE_CONSTRUCTION.nameSet == ("REINFORCED_CONCRETE_CONSTRUCTION", "reinforced_concrete_construction", "鉄筋コンクリート造"))
  }

  test("The REINFORCED_CONCRETE_CONSTRUCTION object detailName is not the same as the specified name set") {
    assert(Structure.REINFORCED_CONCRETE_CONSTRUCTION.nameSet != ("STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION", "steel_framed_reinfoced_concrete_construction", "鉄骨鉄筋コンクリート造"))
  }

  test("The Type obtained from the Type search is the same as the specified REINFORCED_CONCRETE_CONSTRUCTION") {
    assert(Structure.find(3) == Structure.REINFORCED_CONCRETE_CONSTRUCTION)
  }

  test("The Type obtained from the Type search is not the same as the specified REINFORCED_CONCRETE_CONSTRUCTION") {
    assert(Structure.find(4) != Structure.REINFORCED_CONCRETE_CONSTRUCTION)
  }
  */

  /**
   * STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION Test
   */
  /*
  test("The STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION object upperName is the same as the specified string") {
    assert(Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.upperName == "STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION")
  }

  test("The STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION object upperName is not the same as the specified string") {
    assert(Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.upperName != "WOODWORK")
  }

  test("The STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION object lowerName is the same as the specified stwring") {
    assert(Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.lowerName == "steel_framed_reinfoced_concrete_construction")
  }

  test("The STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION object lowerName is not the same as the specified string") {
    assert(Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.lowerName != "woodwork")
  }

  test("STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION code will be the same as the specified number") {
    assert(Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.code == 4)
  }

  test("STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION code will not be the same as the specified number") {
    assert(Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.code != 0)
  }

  test("The STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION object nameSet is the same as the specified name set") {
    assert(Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.nameSet == ("STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION", "steel_framed_reinfoced_concrete_construction", "鉄骨鉄筋コンクリート造"))
  }

  test("The STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION object detailName is not the same as the specified name set") {
    assert(Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.nameSet != ("WOODWORK", "woodwork", "木造"))
  }

  test("The Type obtained from the Type search is the same as the specified STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION") {
    assert(Structure.find(4) == Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION)
  }

  test("The Type obtained from the Type search is not the same as the specified STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION") {
    assert(Structure.find(0) != Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION)
  }
  */
}
