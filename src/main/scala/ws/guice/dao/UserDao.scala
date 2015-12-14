package ws.guice.dao

case class User(id: String, fistName: String, lastName: String) extends Identity

trait Identity {
  val id: String
}

trait Persist[T <: Identity] {
  def insert(t: T): Unit

  def find(id: String): Option[T]
}

class MongoCollection[C <: Identity](name: String) extends Persist[C] {
  private var coll = Map.empty[String, C]

  def insert(t: C): Unit = {
    Thread.sleep(500)
    coll += (t.id -> t)
  }

  def find(id: String): Option[C] = {
    Thread.sleep(500)
    coll.get(id)
  }

}

class UserDao(collection: Persist[User]) {
  def save(user: User): Unit = collection.insert(user)

  def find(id: String): Option[User] = collection.find(id)
}

