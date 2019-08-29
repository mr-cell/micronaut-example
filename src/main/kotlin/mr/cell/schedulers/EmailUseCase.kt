package mr.cell.schedulers

import org.slf4j.LoggerFactory
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Singleton

@Singleton
class EmailUseCase {
    companion object {
        private val LOG = LoggerFactory.getLogger(EmailUseCase::class.java)
    }

    fun send(user: String, message: String) {
        LOG.info("Sending email from {}: {} at {}", user, message, Date().defaultFormat())
    }
}