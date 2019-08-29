package mr.cell

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("mr.cell")
                .mainClass(Application.javaClass)
                .start()
    }
}