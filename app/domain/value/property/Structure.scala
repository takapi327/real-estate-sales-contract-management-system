package domain.value.property

package object structure {

  private lazy val WOODWORK_CODE:                                     Int = 0
  private lazy val LIGHTWEIGHT_STEEL_CONSTRUCTION_CODE:               Int = 1
  private lazy val HEAVY_STEEL_CONSTRUCTION_CODE:                     Int = 2
  private lazy val REINFORCED_CONCRETE_CONSTRUCTION_CODE:             Int = 3
  private lazy val STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION_CODE: Int = 4

  sealed abstract class Structure(rawCode: Int) {
    def upperName = toString
    def lowerName = upperName.toLowerCase
    def code      = rawCode

    def detailName = rawCode match {
      case WOODWORK_CODE                                      => "木造"
      case LIGHTWEIGHT_STEEL_CONSTRUCTION_CODE                => "軽量鉄骨造"
      case HEAVY_STEEL_CONSTRUCTION_CODE                      => "重量鉄骨造"
      case REINFORCED_CONCRETE_CONSTRUCTION_CODE              => "鉄筋コンクリート造"
      case STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION_CODE  => "鉄骨鉄筋コンクリート造"
    }

    def nameSet = (upperName, lowerName, detailName)
  }

  object Structure {
    case object WOODWORK                                     extends Structure(WOODWORK_CODE)
    case object LIGHTWEIGHT_STEEL_CONSTRUCTION               extends Structure(LIGHTWEIGHT_STEEL_CONSTRUCTION_CODE)
    case object HEAVY_STEEL_CONSTRUCTION                     extends Structure(HEAVY_STEEL_CONSTRUCTION_CODE)
    case object REINFORCED_CONCRETE_CONSTRUCTION             extends Structure(REINFORCED_CONCRETE_CONSTRUCTION_CODE)
    case object STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION extends Structure(STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION_CODE)

    def find(rawCode: Int): Structure = {
      rawCode match {
        case WOODWORK_CODE                                     => WOODWORK
        case LIGHTWEIGHT_STEEL_CONSTRUCTION_CODE               => LIGHTWEIGHT_STEEL_CONSTRUCTION
        case HEAVY_STEEL_CONSTRUCTION_CODE                     => HEAVY_STEEL_CONSTRUCTION
        case REINFORCED_CONCRETE_CONSTRUCTION_CODE             => REINFORCED_CONCRETE_CONSTRUCTION
        case STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION_CODE => STEEL_FRAMED_REINFOCED_CONCRETE_CONSTRUCTION
      }
    }
  }
}
