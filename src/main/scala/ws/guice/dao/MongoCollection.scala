package ws.guice.dao

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
