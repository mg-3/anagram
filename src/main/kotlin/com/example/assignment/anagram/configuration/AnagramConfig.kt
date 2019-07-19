package com.example.assignment.anagram.configuration

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.net.URI
import java.nio.file.Files
import java.nio.file.Paths

@Configuration
class AnagramConfig {

    private val logger = LoggerFactory.getLogger(AnagramConfig::class.java)

    @Bean
    fun dictionarySet() : MutableSet<String> {
        return Files.newBufferedReader(Paths.get(URI("file:///Users/mgarcia2/Downloads/platform_dev/dictionary.txt")))
                .readLines().toMutableSet()
//        return mutableSetOf<String>()
    }

}
