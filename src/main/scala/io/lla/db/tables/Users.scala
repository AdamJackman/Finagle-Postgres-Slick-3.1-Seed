package io.lla.db.tables
import slick.driver.PostgresDriver.api._

/**
  * You will see documentation using an Object here extending Table.
  * That doesn't work. Don't believe the lies.
  *
  * the Id column can be ignored. but AutoInc will actually do nothing unless you make postgres do it
  * the very google-able * 'projection' function will not support Apply/Unapply anymore.
  * Do not try like I did.
  *
  * @param tag
  */
class Users (tag: Tag) extends Table[(Option[Int],String,String,String,String,String)](tag, "users") {
  def userId = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
  def firstName = column[String]("first_name")
  def lastName = column[String]("last_name")
  def username = column[String]("user_name")
  def encPass = column[String]("enc_pass")
  def email = column[String]("email")
  def * = (userId, firstName, lastName, username, encPass, email)
}