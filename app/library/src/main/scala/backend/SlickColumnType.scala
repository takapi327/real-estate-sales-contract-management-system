package library.backend

import scala.reflect.ClassTag

import library.model.EntityValue

import java.util.UUID

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

}
