package com.wangc

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class s1_vu extends Simulation {

	val httpProtocol = http
		.baseURL("http://192.168.2.212:8080")
		.inferHtmlResources()

	val scn = scenario("HelloWorld")
			.exec(http("request_0")
			.get("/index_do.jsp?username=aaaaaaa")
			.resources())

// atOnceUsers(n) setting number of vu
	setUp(scn.inject(atOnceUsers(5))).protocols(httpProtocol)
}