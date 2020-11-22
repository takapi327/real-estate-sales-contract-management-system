package domain.value.common

import library.model.{EntityValue, Error}

case class Address(value: String) extends EntityValue[String]

object Address extends Error {

  def apply(rawAddress: String): Either[String, Address] = {
    Either.cond(
      rawAddress.nonEmpty,
      new Address(rawAddress),
      validationError[String](rawAddress)
    )
  }
}
