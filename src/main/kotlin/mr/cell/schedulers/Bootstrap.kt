package mr.cell.schedulers

import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.server.event.ServerStartupEvent
import javax.inject.Singleton

@Singleton
class Bootstrap(val registerUseCase: RegisterUseCase): ApplicationEventListener<ServerStartupEvent> {

    override fun onApplicationEvent(event: ServerStartupEvent) {
        try {
            registerUseCase.register("john@doe.com")
            Thread.sleep(2000)
            registerUseCase.register("jane@johnson.com")
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
    }
}