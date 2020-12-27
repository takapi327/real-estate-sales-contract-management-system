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
  "The HEAVY_STEEL_CONSTRUCTION object upperName is the same as the specified string" in {
    Structure.HEAVY_STEEL_CONSTRUCTION.upperName mustBe "HEAVY_STEEL_CONSTRUCTION"
  }

  "The HEAVY_STEEL_CONSTRUCTION object upperName is not the same as the specified string" in {
    Structure.HEAVY_STEEL_CONSTRUCTION.upperName must not be "REINFORCED_CONCRETE_CONSTRUCTION"
  }

  "The HEAVY_STEEL_CONSTRUCTION object lowerName is the same as the specified stwring" in {
    Structure.HEAVY_STEEL_CONSTRUCTION.lowerName mustBe "heavy_steel_construction"
  }

  "The HEAVY_STEEL_CONSTRUCTION object lowerName is not the same as the specified string" in {
    Structure.HEAVY_STEEL_CONSTRUCTION.lowerName must not be "reinforced_concrete_construction"
  }

  "HEAVY_STEEL_CONSTRUCTION code will be the same as the specified number" in {
    Structure.HEAVY_STEEL_CONSTRUCTION.code mustBe 2
  }

  "HEAVY_STEEL_CONSTRUCTION code will not be the same as the specified number" in {
    Structure.HEAVY_STEEL_CONSTRUCTION.code must not be 3
  }

  "The HEAVY_STEEL_CONSTRUCTION object nameSet is the same as the specified name set" in {
    Structure.HEAVY_STEEL_CONSTRUCTION.nameSet mustBe ("HEAVY_STEEL_CONSTRUCTION", "heavy_steel_construction", "重量鉄骨造")
  }

  "The HEAVY_STEEL_CONSTRUCTION object detailName is not the same as the specified name set" in {
    Structure.HEAVY_STEEL_CONSTRUCTION.nameSet must not be ("REINFORCED_CONCRETE_CONSTRUCTION", "reinforced_concrete_construction", "鉄筋コンクリート造")
  }

  "The Type obtained from the Type search is the same as the specified HEAVY_STEEL_CONSTRUCTION" in {
    Structure.find(2) mustBe Structure.HEAVY_STEEL_CONSTRUCTION
  }

  "The Type obtained from the Type search is not the same as the specified HEAVY_STEEL_CONSTRUCTION" in {
    Structure.find(3) must not be Structure.HEAVY_STEEL_CONSTRUCTION
  }

  /**
   * REINFORCED_CONCRETE_CONSTRUCTION Test
   */
  "The REINFORCED_CONCRETE_CONSTRUCTION object upperName is the same as the specified string" in {
    Structure.REINFORCED_CONCRETE_CONSTRUCTION.upperName mustBe "REINFORCED_CONCRETE_CONSTRUCTION"
  }

  "The REINFORCED_CONCRETE_CONSTRUCTION object upperName is not the same as the specified string" in {
    Structure.REINFORCED_CONCRETE_CONSTRUCTION.upperName must not be "STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION"
  }

  "The REINFORCED_CONCRETE_CONSTRUCTION object lowerName is the same as the specified stwring" in {
    Structure.REINFORCED_CONCRETE_CONSTRUCTION.lowerName mustBe "reinforced_concrete_construction"
  }

  "The REINFORCED_CONCRETE_CONSTRUCTION object lowerName is not the same as the specified string" in {
    Structure.REINFORCED_CONCRETE_CONSTRUCTION.lowerName must not be "steel_framed_reinfoced_concrete_construction"
  }

  "REINFORCED_CONCRETE_CONSTRUCTION code will be the same as the specified number" in {
    Structure.REINFORCED_CONCRETE_CONSTRUCTION.code mustBe 3
  }

  "REINFORCED_CONCRETE_CONSTRUCTION code will not be the same as the specified number" in {
    Structure.REINFORCED_CONCRETE_CONSTRUCTION.code must not be 4
  }

  "The REINFORCED_CONCRETE_CONSTRUCTION object nameSet is the same as the specified name set" in {
    Structure.REINFORCED_CONCRETE_CONSTRUCTION.nameSet mustBe ("REINFORCED_CONCRETE_CONSTRUCTION", "reinforced_concrete_construction", "鉄筋コンクリート造")
  }

  "The REINFORCED_CONCRETE_CONSTRUCTION object detailName is not the same as the specified name set" in {
    Structure.REINFORCED_CONCRETE_CONSTRUCTION.nameSet must not be ("STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION", "steel_framed_reinfoced_concrete_construction", "鉄骨鉄筋コンクリート造")
  }

  "The Type obtained from the Type search is the same as the specified REINFORCED_CONCRETE_CONSTRUCTION" in {
    Structure.find(3) mustBe Structure.REINFORCED_CONCRETE_CONSTRUCTION
  }

  "The Type obtained from the Type search is not the same as the specified REINFORCED_CONCRETE_CONSTRUCTION" in {
    Structure.find(4) must not be Structure.REINFORCED_CONCRETE_CONSTRUCTION
  }

  /**
   * STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION Test
   */
  "The STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION object upperName is the same as the specified string" in {
    Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.upperName mustBe "STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION"
  }

  "The STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION object upperName is not the same as the specified string" in {
    Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.upperName must not be "WOODWORK"
  }

  "The STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION object lowerName is the same as the specified stwring" in {
    Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.lowerName mustBe "steel_framed_reinfoced_concrete_construction"
  }

  "The STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION object lowerName is not the same as the specified string" in {
    Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.lowerName must not be "woodwork"
  }

  "STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION code will be the same as the specified number" in {
    Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.code mustBe 4
  }

  "STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION code will not be the same as the specified number" in {
    Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.code must not be 0
  }

  "The STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION object nameSet is the same as the specified name set" in {
    Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.nameSet mustBe ("STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION", "steel_framed_reinfoced_concrete_construction", "鉄骨鉄筋コンクリート造")
  }

  "The STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION object detailName is not the same as the specified name set" in {
    Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION.nameSet must not be ("WOODWORK", "woodwork", "木造")
  }

  "The Type obtained from the Type search is the same as the specified STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION" in {
    Structure.find(4) mustBe Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION
  }

  "The Type obtained from the Type search is not the same as the specified STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION" in {
    Structure.find(0) must not be Structure.STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION
  }
}
