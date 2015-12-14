package ws.guice.controller

import ws.guice.dao.{Persist, User, UserDao}

class UserController(persist: Persist[User]) {
  private val userDao = new UserDao(persist)

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
