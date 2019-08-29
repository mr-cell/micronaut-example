package mr.cell

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import org.junit.jupiter.api.Assertions.*

object InfoSpec: Spek({
    describe("info endpoint") {
        val embeddedServer: EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        val client: HttpClient = HttpClient.create(embeddedServer.url)

        it("test git commit appears in JSON") {
            val request = HttpRequest.GET<Any>("/info")
            val response = client.toBlocking().exchange(request, Map::class.java)

            assertEquals(HttpStatus.OK, response.status())

            val json = response.body() as Map<String, Any>

            assertNotNull(json["git"])

            val mapCommit = (json["git"] as Map<String, Any>)["commit"] as Map<String, Any>

            assertNotNull(mapCommit)
            assertNotNull(mapCommit["message"])
            assertNotNull(mapCommit["time"])
            assertNotNull(mapCommit["user"])
            assertNotNull(mapCommit["id"])
        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
})