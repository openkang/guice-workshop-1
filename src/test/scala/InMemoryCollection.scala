import ws.guice.dao.{Persist, Identity}

class InMemoryCollection[C <: Identity](name: String) extends Persist[C] {
  private var coll = Map.empty[String, C]

  def insert(t: C): Unit = coll += (t.id -> t)

  def find(id: String): Option[C] = coll.get(id)
}
