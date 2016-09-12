package io.lla.controllers

import com.google.inject.Inject
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import io.lla.db.daos.{User, UserDao}

/**
  * First Basic Controller.
  * Defines 2 endpoints to demonstrate a select and an insert
  * User DAO is injected using Guice.
  * @param userDao
  */
class UserController @Inject()(userDao: UserDao) extends Controller {

  get("/") { request: Request =>
    for {
      usernames <- userDao.getUsernames
    } yield response.ok.json(usernames)
  }

  get("/ins") { request: Request =>
    for {
      ins <- userDao.insertUser(User("Adam2", "Jackman2", "Adam2", "password", "a2@a.com"))
    } yield response.ok.json(ins)
  }
}