package search

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class GoSimulation extends Simulation {

  val protocol = karateProtocol(
    "/search-js" -> Nil
  )

  val searchSenario = scenario("searchGo").exec(karateFeature("classpath:search/go.feature"))

  var MAX_USERS = System.getProperty("numberOfUsers").toInt
  var LAMP_UP = System.getProperty("lampUpSeconds").toInt
  var DURATION = System.getProperty("durationSeconds").toInt
  var injections = Seq(rampUsersPerSec(1) to (MAX_USERS) during(LAMP_UP seconds), constantUsersPerSec(MAX_USERS) during(DURATION seconds))

  setUp(
    searchSenario.inject(injections).protocols(protocol)
  )

}
