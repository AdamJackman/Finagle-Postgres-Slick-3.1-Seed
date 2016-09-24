package io.lla.db.daos

import com.google.inject.{Inject, Singleton}
import com.twitter.util.Future
import io.lla.db.tables.{User, Users}
import slick.driver.PostgresDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global
import io.lla.implications.TwitterConverters.scalaFutureToTwitterFuture
import slick.driver.PostgresDriver.backend.DatabaseDef

/**
  * Slick 3.1 Documentation is a complete Shit Show.
  * Here is a basic usage selection and insertion statement in slick
  *
  */
@Singleton
class UserDao @Inject() (db: DatabaseDef) {
  val users = TableQuery[Users]

  def getUsernames: Future[Seq[String]] = {
    val query = users.map(_.firstName)
    db.run(query.result)
  }

  def insertUser(user: User): Future[Unit] = {
    val insertAction = DBIO.seq(
      users += User(None, user.firstName, user.lastName, user.userName, user.encPass, user.email)
    )
    db.run(insertAction)
  }
}