package ws.guice.dao

case class User(id: String, fistName: String, lastName: String) extends Identity

trait Identity {
  val id: String
}

class MongoCollection[T <: Identity](name: String) {
  private var coll = Map.empty[String, T]

  def insert(t: T): Unit = {
    Thread.sleep(500)
    coll += (t.id -> t)
  }

  def find(id: String): Option[T] = {
    Thread.sleep(500)
    coll.get(id)
  }

}

class UserDao {
  private val collection = new MongoCollection[User]("users")

  def save(user: User): Unit = collection.insert(user)

  def find(id: String): Option[User] = collection.find(id)
}

