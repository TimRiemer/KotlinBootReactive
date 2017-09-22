package mobi.riemer

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@SpringBootTest
class KotlinbootApplicationTests {

    @Test
    fun contextLoads() {
    }

}

// FIXME (tri, 20170922) Test not running anymore with spring-boot-starter-webflux
// worked with experimental reactive support

//@RunWith(SpringRunner::class)
//@WebMvcTest
//class ApplicationTest {
//
//    @Autowired
//    private lateinit var mockMvc: MockMvc
//
//    @Test
//    fun helloWorldShouldWork() {
//        mockMvc
//                .perform(get("/hello").param("name", "World"))
//                .andExpect(status().isOk)
//                .andExpect(content().string("Hello, World\n"))
//    }
//}