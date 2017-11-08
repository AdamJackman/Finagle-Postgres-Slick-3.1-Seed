package io.seed.db.tables
import slick.driver.PostgresDriver.api._

/**
  * Provide a mapping for the Users Table and apply the associated object
  * @param tag
  */
class Users (tag: Tag) extends Table[User](tag, "users") {
  def userId = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
  def firstName = column[String]("first_name")
  def lastName = column[String]("last_name")
  def username = column[String]("user_name")
  def encPass = column[String]("enc_pass")
  def email = column[String]("email")
  def * = (userId, firstName, lastName, username, encPass, email) <> (User.tupled, User.unapply)
}

case class User(
  userId: Option[Int],
  firstName: String,
  lastName: String,
  userName: String,
  encPass: String,
  email: String
)