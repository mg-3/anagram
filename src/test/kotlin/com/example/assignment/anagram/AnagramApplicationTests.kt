package com.example.assignment.anagram

import com.example.assignment.anagram.controllers.AnagramController
import com.example.assignment.anagram.models.AnagramModel
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.CoreMatchers.containsString
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultHandler
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AnagramApplicationTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun contextLoads() {
        val am = AnagramModel(arrayOf("dear", "dare", "read"))

        this.mockMvc.perform(get("/anagrams?word=dare")).andDo(ResultHandler { x -> println(x) }).andExpect(status().isOk)
                .andExpect(content().json("""{"anagrams":["dear","dare","read"]}"""))

//                        .string(containsString("Hello World")))
    }

}
