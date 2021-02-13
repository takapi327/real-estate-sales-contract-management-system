package library.backend

trait SlickDatabaseConfig extends RefinedProfile {

  override val api     = new API with RefinedImplicits
  override val profile = api.slickProfile

  val db: CustomMySQLProfile#Backend#Database = api.Database.forConfig("slick.dbs.default.db")

}

object SlickDatabaseConfig extends SlickDatabaseConfig
