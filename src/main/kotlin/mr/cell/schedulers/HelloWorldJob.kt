package mr.cell.schedulers

import io.micronaut.scheduling.annotation.Scheduled
import org.slf4j.LoggerFactory
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Singleton

@Singleton
class HelloWorldJob {
    companion object {
        private val LOG = LoggerFactory.getLogger(HelloWorldJob::class.java)
    }

    @Scheduled(fixedDelay = "10s")
    fun executeEveryTen() {
        LOG.info("Simple job run every 10s: {}", Date().defaultFormat())
    }

    @Scheduled(fixedDelay = "45s", initialDelay = "5s")
    fun executeEveryFourtyFive() {
        LOG.info("Simple job run every 45s: {}", Date().defaultFormat())
    }
}