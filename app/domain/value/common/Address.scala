package domain.value.common


import eu.timepit.refined._
import eu.timepit.refined.collection._
import eu.timepit.refined.api.Refined

import io.estatico.newtype.macros.newtype


package object address {

  type AddressRule   = collection.NonEmpty
  type AddressString = String Refined AddressRule

  @newtype case class Address(value: AddressString) {
    def v = value.value
  }

  object Address {
    def apply(rawAddress: String): Either[String, Address] = {
      refineV[AddressRule](rawAddress).map(Address(_))
    }
  }
}
