package mobi.riemer

import org.springframework.boot.SpringApplication.run
import org.springframework.boot.autoconfigure.*
import org.springframework.context.*
import org.springframework.context.support.*
import org.springframework.http.MediaType.APPLICATION_STREAM_JSON
import org.springframework.http.MediaType.TEXT_HTML
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.*
import java.time.*

@SpringBootApplication
class KotlinbootApplication : ApplicationContextInitializer<GenericApplicationContext> {

    override fun initialize(applicationContext: GenericApplicationContext) = beans {
        bean<Handler>()
        bean {
            Router(ref()).routes()
        }
    }.initialize(applicationContext)
}

fun main(args: Array<String>) {
    run(KotlinbootApplication::class.java, * args)
}

class Handler {
    fun hello(req: ServerRequest): Mono<ServerResponse> =
            ok().body(
                    Mono.just("Hello, ${req.queryParam("name").orElse("Kotlin")}"),
                    String::class.java
            )

    fun sse(req: ServerRequest): Mono<ServerResponse> =
            ok().bodyToServerSentEvents(
                    Flux.interval(Duration.ofSeconds(1)).map { "Hello $it" }
            )
}

class Router(private val handler: Handler) {
    fun routes() = router {
        ("/" and accept(TEXT_HTML)).nest {
            GET("/hello", handler::hello)
        }
        ("/sse" and accept(APPLICATION_STREAM_JSON)).nest {
            GET("/", handler::sse)
        }
    }
}
