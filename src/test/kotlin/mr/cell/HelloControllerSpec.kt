package mr.cell

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import org.junit.jupiter.api.Assertions.assertEquals


object HelloControllerSpec: Spek({
   describe("HelloController Suite") {
       val embeddedServer: EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
       val client: HttpClient = HttpClient.create(embeddedServer.url)

       it("test /hello responds 'Hello, world!'") {
           val response: String = client.toBlocking().retrieve("/hello")
           assertEquals("Hello, world!", response)
       }

       afterGroup {
           client.close()
           embeddedServer.close()
       }
   }
});