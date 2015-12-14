package ws.guice.controller

import ws.guice.dao.{User, UserDao}

class UserController(userDao: UserDao) {
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
