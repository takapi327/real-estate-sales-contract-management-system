package domain.value.property.structure

import org.scalatest._
import org.scalatestplus.play._

class StructureTest extends FunSuite {

  /**
   * WOODWORK Test
   */
  test("The WOODWORK object upperName is the same as the specified string") {
    assert(Structure.WOODWORK.upperName == "WOODWORK")
  }

  test("The WOODWORK object upperName is not the same as the specified string") {
    assert(Structure.WOODWORK.upperName != "LIGHTWEIGHT_STEEL_CONSTRUCTION")
  }

  test("The WOODWORK object lowerName is the same as the specified string") {
    assert(Structure.WOODWORK.lowerName == "woodwork")
  }

  test("The WOODWORK object lowerName is not the same as the specified string") {
    assert(Structure.WOODWORK.lowerName != "lightweight_steel_construction")
  }

  test("WOODWORK code will be the same as the specified number") {
    assert(Structure.WOODWORK.code == 0)
  }

  test("WOODWORK code will not be the same as the specified number") {
    assert(Structure.WOODWORK.code != 1)
  }

  test("The WOODWORK object nameSet is the same as the specified name set") {
    assert(Structure.WOODWORK.nameSet == ("WOODWORK", "woodwork", "木造"))
  }

  test("The WOODWORK object detailName is not the same as the specified name set") {
    assert(Structure.WOODWORK.nameSet != ("LIGHTWEIGHT_STEEL_CONSTRUCTION", "lightweight_steel_construction", "軽量鉄骨造"))
  }

  test("The Type obtained from the Type search is the same as the specified WOODWORK") {
    assert(Structure.find(0) == Structure.WOODWORK)
  }

  test("The Type obtained from the Type search is not the same as the specified WOODWORK") {
    assert(Structure.find(1) != Structure.WOODWORK)
  }

  /**
   * LIGHTWEIGHT_STEEL_CONSTRUCTION Test
   */
  test("The LIGHTWEIGHT_STEEL_CONSTRUCTION object upperName is the same as the specified string") {
    assert(Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.upperName == "LIGHTWEIGHT_STEEL_CONSTRUCTION")
  }

  test("The LIGHTWEIGHT_STEEL_CONSTRUCTION object upperName is not the same as the specified string") {
    assert(Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.upperName != "HEAVY_STEEL_CONSTRUCTION")
  }

  test("The LIGHTWEIGHT_STEEL_CONSTRUCTION object lowerName is the same as the specified stwring") {
    assert(Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.lowerName == "lightweight_steel_construction")
  }

  test("The LIGHTWEIGHT_STEEL_CONSTRUCTION object lowerName is not the same as the specified string") {
    assert(Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.lowerName != "heavy_steel_construction")
  }

  test("LIGHTWEIGHT_STEEL_CONSTRUCTION code will be the same as the specified number") {
    assert(Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.code == 1)
  }

  test("LIGHTWEIGHT_STEEL_CONSTRUCTION code will not be the same as the specified number") {
    assert(Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.code != 2)
  }

  test("The LIGHTWEIGHT_STEEL_CONSTRUCTION object nameSet is the same as the specified name set") {
    assert(Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.nameSet == ("LIGHTWEIGHT_STEEL_CONSTRUCTION", "lightweight_steel_construction", "軽量鉄骨造"))
  }

  test("The LIGHTWEIGHT_STEEL_CONSTRUCTION object detailName is not the same as the specified name set") {
    assert(Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION.nameSet != ("HEAVY_STEEL_CONSTRUCTION", "heavy_steel_construction", "重量鉄骨造"))
  }

  test("The Type obtained from the Type search is the same as the specified LIGHTWEIGHT_STEEL_CONSTRUCTION") {
    assert(Structure.find(1) == Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION)
  }

  test("The Type obtained from the Type search is not the same as the specified LIGHTWEIGHT_STEEL_CONSTRUCTION") {
    assert(Structure.find(2) != Structure.LIGHTWEIGHT_STEEL_CONSTRUCTION)
  }

  /**
   * HEAVY_STEEL_CONSTRUCTION Test
   */
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

  /**
   * REINFORCED_CONCRETE_CONSTRUCTION Test
   */
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

  /**
   * STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION Test
   */
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
}
