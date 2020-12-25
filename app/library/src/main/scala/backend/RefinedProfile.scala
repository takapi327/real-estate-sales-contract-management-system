package library.backend

//import slick.jdbc.JdbcProfile
import slick.jdbc.MySQLProfile

import be.venneborg.refined.RefinedMapping
import be.venneborg.refined.RefinedSupport

trait RefinedProfile extends MySQLProfile
  with RefinedMapping
  with RefinedSupport

object RefinedProfile extends RefinedProfile
