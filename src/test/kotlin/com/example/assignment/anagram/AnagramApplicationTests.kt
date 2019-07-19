package com.example.assignment.anagram

import com.google.common.hash.BloomFilter
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

    @Autowired
    private lateinit var permutations: Permutations

    @Autowired
    private lateinit var dictionaryBloomFilter: BloomFilter<String>

    @Autowired lateinit var dictionarySet: Set<String>
    @Test
    fun getAnagram() {
            this.mockMvc.perform(get("/anagrams?word=dare"))
                .andDo(ResultHandler { x -> println(x.response.contentAsString) })
                .andExpect(status().isOk)
                .andExpect(content().json("""{"anagrams":["dear","dare","read"]}"""))
    }

    @Test
    fun permutation_1() {
        val s = "dare"
        dictionarySet = mutableSetOf("dear", "dare", "read", "foobar")
        permutations.perm2(s)
                .filter { p -> dictionarySet.contains(p) }
                .filter { p -> p != s}
                .forEach { p -> println(p) }
    }

}
