package library.backend

import scala.concurrent.ExecutionContext

import akka.Done
import play.api.Application
import play.api.inject.guice.GuiceApplicationBuilder

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

  import play.api.Configuration
  import play.api.inject.bind
  import com.typesafe.config.ConfigFactory
  import java.io.File

    val testConfigFile = new File("conf/test.conf")
    val parsedConfig   = ConfigFactory.parseFile(testConfigFile)
    val configuration  = ConfigFactory.load(parsedConfig)

    override lazy val fakeApplication: Application = new GuiceApplicationBuilder()
      .overrides(bind[Configuration].toInstance(Configuration(configuration)))
      .build()

    override def afterAll(): Unit = {
      fakeApplication.stop().mapTo[Done].futureValue
    }
}
