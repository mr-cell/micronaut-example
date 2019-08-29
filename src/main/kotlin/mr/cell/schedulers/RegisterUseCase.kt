package mr.cell.schedulers

import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.TaskScheduler
import org.slf4j.LoggerFactory
import java.time.Duration
import java.util.*
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class RegisterUseCase(private val emailUseCase: EmailUseCase,
                      @param:Named(TaskExecutors.SCHEDULED) private val taskScheduler: TaskScheduler) {

    companion object {
        private val LOG = LoggerFactory.getLogger(RegisterUseCase::class.java)
    }

    fun register(email: String) {
        LOG.info("Saving {} at {}", email, Date().defaultFormat())
        scheduleFollowupEmail(email, "Welcome to Micronaut")
    }

    private fun scheduleFollowupEmail(email: String, message: String) {
        val task = EmailTask(emailUseCase, email, message)
        taskScheduler.schedule(Duration.ofSeconds(5), task)
    }

}
