package library.backend

import slick.jdbc.JdbcProfile

import be.venneborg.refined.RefinedMapping
import be.venneborg.refined.RefinedSupport

trait RefinedProfile extends JdbcProfile
  with RefinedMapping
  with RefinedSupport

object RefinedProfile extends RefinedProfile
