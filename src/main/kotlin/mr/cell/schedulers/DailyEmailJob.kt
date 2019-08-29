package mr.cell.schedulers

import io.micronaut.scheduling.annotation.Scheduled
import javax.inject.Singleton

@Singleton
class DailyEmailJob(private val emailUseCase: EmailUseCase) {

//    @Scheduled(cron = "0 30 4 1/1 * ?")
    @Scheduled(fixedRate = "2s")
    fun execute() {
        emailUseCase.send("john@doe.com", "test message")
    }
}