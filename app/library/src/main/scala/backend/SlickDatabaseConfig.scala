package library.backend

import slick.jdbc.JdbcProfile

trait SlickDatabaseConfig extends RefinedProfile {

  override val api = new API with RefinedImplicits

  import api._

  val db: JdbcProfile#Backend#Database = Database.forConfig("database")

}

object SlickDatabaseConfig extends SlickDatabaseConfig
