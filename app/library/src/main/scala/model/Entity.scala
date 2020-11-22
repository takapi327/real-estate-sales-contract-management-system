package library.model

import java.util.UUID

trait EntityEmbededId {

  case class Id(value: UUID)

}
