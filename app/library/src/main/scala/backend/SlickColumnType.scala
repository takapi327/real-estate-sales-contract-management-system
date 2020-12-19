package library.backend

import java.util.UUID
import java.time.LocalDate

import scala.reflect.ClassTag

import library.model.EntityValue

trait SlickColumnType extends SlickDatabaseConfig {
  import api._

  implicit def ValueUUIDType[T <: EntityValue[UUID]](implicit tag: ClassTag[T]) = {
    MappedColumnType.base[T, String](
      vo  => vo.value.toString,
      str => tag.runtimeClass
       .getConstructor(classOf[UUID])
       .newInstance(UUID.fromString(str))
       .asInstanceOf[T]
    )
  }

  implicit def ValueBirthDate[T <: EntityValue[LocalDate]](implicit tag: ClassTag[T]) = {
    MappedColumnType.base[T, LocalDate](
      vo  => vo.value,
      str => tag.runtimeClass
        .getConstructor(classOf[LocalDate])
        .newInstance(str)
        .asInstanceOf[T]
    )
  }
}
