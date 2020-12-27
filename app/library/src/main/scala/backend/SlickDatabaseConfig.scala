package library.backend

import slick.jdbc.MySQLProfile

trait SlickDatabaseConfig extends RefinedProfile {

  override val api = new API with RefinedImplicits

  import api._

  val db: MySQLProfile#Backend#Database = Database.forConfig("slick.dbs.default.db")

}

object SlickDatabaseConfig extends SlickDatabaseConfig
