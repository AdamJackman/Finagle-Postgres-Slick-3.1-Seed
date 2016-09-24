package io.lla
import com.twitter.finagle.http.Status
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest
import org.scalatest.WordSpec

class GetTest extends FeatureTest {
  val server = new EmbeddedHttpServer(new ServerMain)

  "Server" should {
    "Respond to a simple get" in {
      server.httpGet(path = "/", andExpect = Status.Ok)
    }
    "Respond 404 to a bogus get" in {
      server.httpGet(path = "/badPath", andExpect = Status.NotFound)
    }
  }
}