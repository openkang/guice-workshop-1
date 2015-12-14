package ws.guice.controller

import ws.guice.dao.{MongoCollection, User, UserDao}

class UserController {
  val mongoCollection = new MongoCollection[User]("users")
  private val userDao = new UserDao(mongoCollection)

  def register(email: String, firstName: String, lastName: String) = {
    userDao.find(email) match {
      case None =>
        val user = User(email, firstName, lastName)
        userDao.save(user)

        "success"
      case _    => "conflict"
    }
  }
}
