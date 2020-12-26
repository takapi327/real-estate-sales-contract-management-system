package library.backend

import scala.concurrent.ExecutionContext

import akka.Done
import play.api.Application
import play.api.inject.guice.GuiceApplicationBuilder
//import play.api.db.slick.DatabaseConfigProvider

import org.scalatest.BeforeAndAfterAll
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Millis, Seconds, Span}
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite

trait SlickRepositorySpec extends PlaySpec
  with GuiceOneAppPerSuite
  with ScalaFutures
  with BeforeAndAfterAll {

    implicit lazy val ec: ExecutionContext = fakeApplication.actorSystem.dispatcher

    override implicit val patienceConfig: PatienceConfig = PatienceConfig(
      timeout  = Span(10,   Seconds),
      interval = Span(1000, Millis)
    )

    override lazy val fakeApplication: Application = new GuiceApplicationBuilder()
      .configure(Map(
        "slick.dbs.default.profile"     -> "com.mysql.Driver",
        "slick.dbs.default.db.driver"   -> "slick.driver.MySQLDriver$",
        "slick.dbs.default.db.url"      -> "jdbc:mysql://localhost/contract_management_system_test?useSSL=false",
        "slick.dbs.default.db.user"     -> "root",
        "slick.dbs.default.db.password" -> "transamGN001"
      )).build()

    override def afterAll(): Unit = {
      fakeApplication.stop().mapTo[Done].futureValue
    }
}
