package com.wangc

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class s0_tomcat extends Simulation {

  val httpProtocol = http
    .baseURL("http://10.7.13.142:8080")
    .inferHtmlResources()

  val scn = scenario("HelloWorld").during(2){
    exec(http("request_0")
      .get("/my.jsp")
      .resources())
  }

  setUp(scn.inject(atOnceUsers(5))).protocols(httpProtocol)
}
