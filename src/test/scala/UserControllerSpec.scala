import ws.guice.controller.UserController
import ws.guice.dao.{Identity, Persist, User}

class InMemoryCollection[C <: Identity](name: String) extends Persist[C] {
  private var coll = Map.empty[String, C]

  def insert(t: C): Unit = coll += (t.id -> t)

  def find(id: String): Option[C] = coll.get(id)
}

object UserControllerSpec extends App {
  val inMemoryCollection = new InMemoryCollection[User]("users")
  val userController = new UserController(inMemoryCollection)

  def should_return_success_when_new_user_registers: Unit = {
    val result = userController.register("focusj.x@gmail.com", "kang", "wang")

    assert(result == "success")
  }

  def should_return_failure_when_user_already_exists: Unit = {
    userController.register("focusj.x@gmail.com", "kang", "wang")

    val result = userController.register("focusj.x@gmail.com", "kang", "wang")

    assert(result == "conflict")
  }

  should_return_success_when_new_user_registers
  should_return_failure_when_user_already_exists
}