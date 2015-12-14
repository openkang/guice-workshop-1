import com.google.inject.{AbstractModule, Provides}
import net.codingwell.scalaguice.ScalaModule
import ws.guice.controller.UserController
import ws.guice.dao.{MongoCollection, Persist, User, UserDao}

class TestAppModules extends AbstractModule with ScalaModule {
  override def configure(): Unit = {
    bind[Persist[User]].toInstance(new InMemoryCollection[User]("user"))
  }

  @Provides
  def provideUserDao(persist: Persist[User]) = new UserDao(persist)

  @Provides
  def provideUserController(userDao: UserDao) = new UserController(userDao)
}
