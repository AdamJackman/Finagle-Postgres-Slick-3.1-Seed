package io.lla.modules

import com.google.inject.{Provides, Singleton}
import com.twitter.inject.TwitterModule
import slick.driver.PostgresDriver.backend.DatabaseDef
import slick.driver.PostgresDriver.api._


object DatabaseModule extends TwitterModule {
  val dbConfig = flag("db", "dev", "Sets the db config resource to use")

  @Singleton
  @Provides
  def providesDatabaseConnection: DatabaseDef = {
    Database.forConfig(dbConfig())
  }
}
