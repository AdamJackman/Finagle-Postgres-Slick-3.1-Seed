package io.lla

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter
import io.lla.controllers.UserController
	
object Server extends ServerMain
class ServerMain extends HttpServer {

  override val defaultFinatraHttpPort: String = ":8080" //Not Necessary, but customize like this

  override val modules = Seq() //Singletons that depend on flags, Timed Jobs go here

  override def configureHttp(router: HttpRouter): Unit = {
    router.add[UserController]
  }

}