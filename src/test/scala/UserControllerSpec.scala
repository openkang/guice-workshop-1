import ws.guice.controller.UserController
import ws.guice.dao.{MongoCollection, User, Identity, Persist}

object UserControllerSpec extends App {
  val mongoCollection = new MongoCollection[User]("users")
  val userController = new UserController(mongoCollection)

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