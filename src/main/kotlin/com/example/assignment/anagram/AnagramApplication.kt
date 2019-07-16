package com.example.assignment.anagram

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableWebMvc
class AnagramApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<AnagramApplication>(*args)
        }
    }
}