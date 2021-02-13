package library.backend

import be.venneborg.refined.RefinedMapping
import be.venneborg.refined.RefinedSupport

trait RefinedProfile extends CustomMySQLProfile
  with RefinedMapping
  with RefinedSupport

object RefinedProfile extends RefinedProfile
