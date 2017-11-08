package io.seed

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter
import io.seed.controllers.UserController
import io.seed.modules.DatabaseModule
	
object Server extends ServerMain
class ServerMain extends HttpServer {

  override val defaultFinatraHttpPort: String = ":8080" // Not Necessary, but customize like this

  override val modules = Seq(
    DatabaseModule
  )

  override def configureHttp(router: HttpRouter): Unit = {
    router.add[UserController]
  }

}