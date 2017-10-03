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
            .bindToRouterFunction(Router(Handler()).routes())
            .build()

    @Test
    fun helloShouldReturnStatusOkAndBodyShouldContainParameter() {
        webTestClient
                .get().uri("/hello?name=Spring")
                .exchange().expectStatus().isOk
                //.expectBody(String::class.java).isEqualTo<Nothing>("Hello, Spring\n")        //fixed with KT-5464 in Kotlin 1.2
                .expectBody().equals("Hello, Spring\n")
    }

    @Test
    fun helloShouldReturnStatusOkAndWithoutParameterBodyShouldContainKotlin() {
        webTestClient
                .get().uri("/hello?name=Kotlin")
                .exchange().expectStatus().isOk
                //.expectBody(String::class.java).isEqualTo<Nothing>("Hello, Kotlin\n")        //fixed with KT-5464 in Kotlin 1.2
                .expectBody().equals("Hello, Kotlin\n")
    }
}