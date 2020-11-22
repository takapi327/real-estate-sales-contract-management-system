package domain.value.property
/*
import eu.timepit.refined._
import eu.timepit.refined.collection._
import eu.timepit.refined.string._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype

package object price {

  type PriceRule   = MatchesRegex["""\b\d{1,3}(,\d{3})*\b"""]
  type PriceString = String Refined PriceRule

  @newtype case class Price(value: PriceString)

  object Price {
    def apply(rawPrice: String): Either[String, Price] = {
      refineV[PriceRule](rawPrice).map(Price(_))
    }
  }
}
*/
import library.model.{EntityValue, Error}

case class Price(value: String) extends EntityValue[String]

object Price extends Error {

  def apply(rawPrice: String): Either[String, Price] = {
    Either.cond(
      rawPrice.matches("""\b\d{1,3}(,\d{3})*\b"""),
      new Price(rawPrice),
      validationError[String](rawPrice)
    )
  }
}
