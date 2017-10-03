package mobi.riemer

import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.*
import org.springframework.boot.test.context.*
import org.springframework.test.context.junit.jupiter.*
import org.springframework.test.web.reactive.server.*


@ExtendWith(SpringExtension::class)
@SpringBootTest
class KotlinbootApplicationTests {

    @Test
    fun contextLoads() {
    }
}

class ApplicationTest {

    private val webTestClient = WebTestClient
            .bindToController(KotlinbootApplication.HelloWorldController())
            .build()

    @Test
    fun helloWorldShouldWork() {
        webTestClient
                .get().uri("/hello?name=World")
                .exchange().expectStatus().isOk
                //.expectBody(String::class.java).isEqualTo<Nothing>("Hello, World\n")        //fixed with KT-5464 in Kotlin 1.2
                .expectBody().equals("Hello, World\n")
    }
}