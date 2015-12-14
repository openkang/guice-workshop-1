package ws.guice

import com.google.inject.Guice
import ws.guice.controller.UserController

object Main extends App {
  val injector = Guice.createInjector(new AppModules)

  val userController = injector.getInstance(classOf[UserController])

  userController.register("focusj.x@gmail.com", "kang", "wang")
}
