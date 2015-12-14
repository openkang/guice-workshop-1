package ws.guice.dao

trait Persist[T <: Identity] {
  def insert(t: T): Unit

  def find(id: String): Option[T]
}
