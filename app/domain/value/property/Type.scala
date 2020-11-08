package domain.value.property

package object types {

  private lazy val LAND_CODE:               Int = 0
  private lazy val DETACHED_HOUSE_CODE:     Int = 1
  private lazy val APARTMENT_BUILDING_CODE: Int = 2

  sealed abstract class Type(rawCode: Int) {
    def upperName = toString
    def lowerName = upperName.toLowerCase
    def code      = rawCode

    def detailName = code match {
      case LAND_CODE               => "土地"
      case DETACHED_HOUSE_CODE     => "戸建て"
      case APARTMENT_BUILDING_CODE => "マンション"
    }

    def nameSet = (upperName, lowerName, detailName)
  }

  object Type {
    case object LAND               extends Type(LAND_CODE)
    case object DETACHED_HOUSE     extends Type(DETACHED_HOUSE_CODE)
    case object APARTMENT_BUILDING extends Type(APARTMENT_BUILDING_CODE)

    def find(rawCode: Int): Type = {
      rawCode match {
        case LAND_CODE               => LAND
        case DETACHED_HOUSE_CODE     => DETACHED_HOUSE
        case APARTMENT_BUILDING_CODE => APARTMENT_BUILDING
      }
    }
  }
}
