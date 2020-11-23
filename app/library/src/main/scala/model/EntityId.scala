package library.model

import java.util.UUID

trait EntityId {

  case class Id(value: UUID)

}
