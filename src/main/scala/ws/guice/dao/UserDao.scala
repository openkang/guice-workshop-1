package ws.guice.dao

import javax.inject.Inject

case class User(id: String, fistName: String, lastName: String) extends Identity

trait Identity {
  val id: String
}

class UserDao @Inject() (
  collection: Persist[User]
) {
  def save(user: User): Unit = collection.insert(user)

  def find(id: String): Option[User] = collection.find(id)
}

