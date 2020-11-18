package domain.model.company

import java.util.UUID

import domain.value.common.phone._
import domain.value.common.email._

import io.estatico.newtype.macros.newtype

case class Company (
  companyId:           Company.Id,
  companyName:         Company.Name,
  dateOfEstablishment: Company.Date,
  address:             String,
  phoneNumber:         PhoneNumber,
  email:               Email
)

