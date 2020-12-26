package domain.value.property

import org.scalatest._
import org.scalatestplus.play._

class TypeTest extends PlaySpec {

  /**
   * LAND Test
   */
  "The LAND object upperName is the same as the specified string" in {
    Type.LAND.upperName mustBe "LAND"
  }

  "The LAND object upperName is not the same as the specified string" in {
    Type.LAND.upperName must not be "DETACHED_HOUSE_CODE"
  }

  "The LAND object lowerName is the same as the specified string" in {
    Type.LAND.lowerName mustBe "land"
  }

  "The LAND object lowerName is not the same as the specified string" in {
    Type.LAND.lowerName must not be "detached_house"
  }

  "Land code will be the same as the specified number" in {
    Type.LAND.code mustBe 0
  }

  "Land code will not be the same as the specified number" in {
    Type.LAND.code must not be 1
  }

  "The LAND object nameSet is the same as the specified name set" in {
    Type.LAND.nameSet mustBe ("LAND", "land", "土地")
  }

  "The LAND object detailName is not the same as the specified name set" in {
    Type.LAND.nameSet must not be ("DETACHED_HOUSE", "detached_houde", "戸建て")
  }

  "The Type obtained from the Type search is the same as the specified LAND" in {
    Type.find(0) mustBe Type.LAND
  }

  "The Type obtained from the Type search is not the same as the specified LAND." in {
    Type.find(1) must not be Type.LAND
  }

  /**
   * DETACHED_HOUSE Test
   */
  "The DETACHED_HOUSE object upperName is the same as the specified string" in {
    Type.DETACHED_HOUSE.upperName mustBe "DETACHED_HOUSE"
  }

  "The DETACHED_HOUSE object upperName is not the same as the specified string" in {
    Type.DETACHED_HOUSE.upperName must not be "APARTMENT_BUILDING"
  }

  "The DETACHED_HOUSE object lowerName is the same as the specified string" in {
    Type.DETACHED_HOUSE.lowerName mustBe "detached_house"
  }

  "The DETACHED_HOUSE object lowerName is not the same as the specified string" in {
    Type.DETACHED_HOUSE.lowerName must not be "apartment_building"
  }

  "DETACHED_HOUSE code will be the same as the specified number" in {
    Type.DETACHED_HOUSE.code mustBe 1
  }

  "DETACHED_HOUSE code will not be the same as the specified number" in {
    Type.DETACHED_HOUSE.code must not be 2
  }

  "The DETACHED_HOUSE object nameSet is the same as the specified name set" in {
    Type.DETACHED_HOUSE.nameSet mustBe ("DETACHED_HOUSE", "detached_house", "戸建て")
  }

  "The DETACHED_HOUSE object detailName is not the same as the specified name set" in {
    Type.DETACHED_HOUSE.nameSet must not be ("APARTMENT_BUILDING", "apartment_building", "マンション")
  }

  "The Type obtained from the Type search is the same as the specified DETACHED_HOUSE" in {
    Type.find(1) mustBe Type.DETACHED_HOUSE
  }

  "The Type obtained from the Type search is not the same as the specified DETACHED_HOUSE" in {
    Type.find(2) must not be Type.DETACHED_HOUSE
  }

  /**
   * APARTMENT_BUILDING Test
   */
  "The APARTMENT_BUILDING object upperName is the same as the specified string" in {
    Type.APARTMENT_BUILDING.upperName mustBe "APARTMENT_BUILDING"
  }

  "The APARTMENT_BUILDING object upperName is not the same as the specified string" in {
    Type.APARTMENT_BUILDING.upperName must not be "LAND"
  }

  "The APARTMENT_BUILDING object lowerName is the same as the specified string" in {
    Type.APARTMENT_BUILDING.lowerName mustBe "apartment_building"
  }

  "The APARTMENT_BUILDING object lowerName is not the same as the specified string" in {
    Type.APARTMENT_BUILDING.lowerName must not be "land"
  }

  "APARTMENT_BUILDING code will be the same as the specified number" in {
    Type.APARTMENT_BUILDING.code mustBe 2
  }

  "APARTMENT_BUILDING code will not be the same as the specified number" in {
    Type.APARTMENT_BUILDING.code must not be 0
  }

  "The APARTMENT_BUILDING object nameSet is the same as the specified name set" in {
    Type.APARTMENT_BUILDING.nameSet mustBe ("APARTMENT_BUILDING", "apartment_building", "マンション")
  }

  "The APARTMENT_BUILDING object detailName is not the same as the specified name set" in {
    Type.APARTMENT_BUILDING.nameSet must not be ("LAND", "land", "土地")
  }

  "The Type obtained from the Type search is the same as the specified APARTMENT_BUILDING" in {
    Type.find(2) mustBe Type.APARTMENT_BUILDING
  }

  "The Type obtained from the Type search is not the same as the specified APARTMENT_BUILDING" in {
    Type.find(0) must not be Type.APARTMENT_BUILDING
  }
}
