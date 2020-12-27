package library.backend

import slick.lifted.Tag

import SlickDatabaseConfig.profile._

abstract class SlickTable[M](
  tag:       Tag,
  tableName: String
) extends Table[M](tag, tableName)
  with    SlickColumnType
