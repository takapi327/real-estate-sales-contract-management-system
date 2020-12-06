package library.backend

import scala.reflect.ClassTag

import library.model.EntityValue

import java.util.UUID

trait RefinedColumnType extends SlickDatabaseConfig {
  import api._

  implicit def ValueIntType[T <: EntityValue[UUID]](implicit tag: ClassTag[T]) = {
    MappedColumnType.base[T, String](
      v   => v.value.toString,
      str => tag.runtimeClass
       .getConstructor(classOf[UUID])
       .newInstance(UUID.fromString(str))
       .asInstanceOf[T]
    )
  }
}
