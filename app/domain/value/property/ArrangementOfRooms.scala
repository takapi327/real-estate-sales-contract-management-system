package domain.value.property
/*
import eu.timepit.refined._
import eu.timepit.refined.collection._
import eu.timepit.refined.string._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype

package object arrangementofrooms {

  type ArrangementOfRoomsRule   = MatchesRegex["""[1-9]+[A-Z]+[A-Z]"""]
  type ArrangementOfRoomsString = String Refined ArrangementOfRoomsRule

  @newtype case class ArrangementOfRooms(value: ArrangementOfRoomsString)

  object ArrangementOfRooms {
    def apply(rawArrangementOfRooms: String): Either[String, ArrangementOfRooms] = {
      refineV[ArrangementOfRoomsRule](rawArrangementOfRooms).map(ArrangementOfRooms(_))
    }
  }

}
*/
import library.model.{EntityValue, Error}

case class ArrangementOfRooms(value: String) extends EntityValue[String]

object ArrangementOfRooms extends Error {

  def apply(rawArrangementOfRooms: String): Either[String, ArrangementOfRooms] = {
    Either.cond(
      rawArrangementOfRooms.matches("""[1-9]+[A-Z]+[A-Z]"""),
      new ArrangementOfRooms(rawArrangementOfRooms),
      validationError[String](rawArrangementOfRooms)
    )
  }
}
