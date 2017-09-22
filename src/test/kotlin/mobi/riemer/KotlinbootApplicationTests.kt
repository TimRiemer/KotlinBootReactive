package mobi.riemer

import org.junit.*
import org.junit.runner.*
import org.springframework.boot.test.context.*
import org.springframework.test.context.junit4.*
import org.springframework.test.web.reactive.server.*


@RunWith(SpringRunner::class)
@SpringBootTest
class KotlinbootApplicationTests {

    @Test
    fun contextLoads() {
    }

}

@RunWith(SpringRunner::class)
class ApplicationTest {

    private val webTestClient = WebTestClient
            .bindToController(KotlinbootApplication.HelloWorldController())
            .build()!!

    @Test
    fun helloWorldShouldWork() {
        webTestClient
                .get().uri("/hello?name=World")
                .exchange().expectStatus().isOk
                //.expectBody(String::class.java).isEqualTo<Nothing>("Hello, World\n")        //fixed with KT-5464 in Kotlin 1.2
                .expectBody().equals("Hello, World\n")
    }
}