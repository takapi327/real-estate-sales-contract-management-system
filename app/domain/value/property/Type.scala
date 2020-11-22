package domain.value.property

sealed abstract class Type(rawCode: Int,  detailName: String) {
  def upperName = toString
  def lowerName = upperName.toLowerCase
  def code      = rawCode
  def nameSet   = (upperName, lowerName, detailName)
}

object Type {

  private lazy val LAND_CODE:               Int = 0
  private lazy val DETACHED_HOUSE_CODE:     Int = 1
  private lazy val APARTMENT_BUILDING_CODE: Int = 2

  case object LAND               extends Type(LAND_CODE,               "土地")
  case object DETACHED_HOUSE     extends Type(DETACHED_HOUSE_CODE,     "戸建て")
  case object APARTMENT_BUILDING extends Type(APARTMENT_BUILDING_CODE, "マンション")

  def find(rawCode: Int): Type = {
    rawCode match {
      case LAND_CODE               => LAND
      case DETACHED_HOUSE_CODE     => DETACHED_HOUSE
      case APARTMENT_BUILDING_CODE => APARTMENT_BUILDING
    }
  }
}
