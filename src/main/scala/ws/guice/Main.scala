package ws.guice

import ws.guice.controller.UserController
import ws.guice.dao.{MongoCollection, User, UserDao}

class Main {
  val mongoCollection = new MongoCollection[User]("users")
  val userDao = new UserDao(mongoCollection)
  val userController = new UserController(userDao)

  userController.register("focusj.x@gmail.com", "kang", "wang")
}
