package io.seed
import com.twitter.finagle.http.Status
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest


class GetTest extends FeatureTest {
  val server = new EmbeddedHttpServer(new ServerMain)

  test("Respond to a simple get") {
    server.httpGet(path = "/", andExpect = Status.Ok)
  }
  test("Respond 404 to a bogus get") {
    server.httpGet(path = "/badPath", andExpect = Status.NotFound)
  }
}