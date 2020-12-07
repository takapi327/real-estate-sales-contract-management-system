package domain.value.common

import eu.timepit.refined._
import eu.timepit.refined.numeric._
import eu.timepit.refined.api.Refined

//import io.estatico.newtype.macros.newtype
import io.estatico.newtype.NewType

import library.model.{EntityValue, Error}

/*
package object age {

  type AgeRule = Interval.OpenClosed[0, 150]
  type AgeInt  = Int Refined AgeRule

  @newtype case class Age(value: AgeInt) {
    def v = value.value
  }

  object Age {
    def apply(rawAge: Int): Either[String, Age] = {
      refineV[AgeRule](rawAge).map(Age(_))
    }

  }
}
*/
package object age {

  type AgeRule = Interval.OpenClosed[0, 150]
  type AgeInt  = Int Refined AgeRule

  case class Age(value: AgeInt) extends EntityValue[AgeInt] {
    def v = value.value
  }

  object Age {
    def apply(rawAge: Int): Either[String, Age] = {
      refineV[AgeRule](rawAge).map(Age(_))
    }

  }
}

import eu.timepit.refined.collection._
import io.estatico.newtype.macros.newtype
import io.estatico.newtype.ops._

package object test {
  type IdType = String Refined NonEmpty
  type PasswordType = String Refined NonEmpty

  type Name = Name.Type
  //case class Name(value: String)
  /*
  object Name extends NewType.Of[String] {
    def apply(value: String) = wrap(value)

    implicit final class Ops(val self: Type) extends AnyVal {
      def value: String = self.coerce[String]
    }
  }
  */
  object Name extends RefinedValue[String]

  /*
  @newtype case class Id(value: String)
  @newtype case class Password(value: String)
  */
  case class Id(value: String) extends NewType.Default[String]
  case class Password(value: String) extends NewType.Default[String]
  case class LoginInfo(id: Id, password: Password, name: Name)

  val validId   = Id("my1d123")
  val password  = Password("Passw0rd!")
  val name      = Name("hogehoge")
  val h         = Name.unwrap
  val string    = name.coerce[String]
  val loginInfo = LoginInfo(id = validId, password = password, name = name)
  //val loginInfo2 = LoginInfo(id = validId, password = name, name = name)
}
