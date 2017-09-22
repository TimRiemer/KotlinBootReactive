package mobi.riemer

import org.springframework.boot.SpringApplication.run
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class KotlinbootApplication {

    @RestController
    @RequestMapping(value = "/hello")
    class HelloWorldController {
        @GetMapping
        fun helloWorld(@RequestParam name: String) = "Hello, $name\n"
    }
}

fun main(args: Array<String>) {
    run(KotlinbootApplication::class.java, * args)
}


