package com.example.assignment.anagram.controllers

import com.example.assignment.anagram.models.AnagramModel
import org.springframework.web.bind.annotation.*

@RestController
class AnagramController {

    @RequestMapping(
            value = ["/anagrams"],
            method = [RequestMethod.GET]
    )
    fun getAnagrams(@RequestParam("word") word: String) : AnagramModel {
        return AnagramModel(arrayOf("dear", "dare", "read"))
    }

    @RequestMapping(
            value = ["/words.json"],
            method = [RequestMethod.POST]
    )
    fun test(@RequestBody anagramModel: AnagramModel) : String {
        return "ok - $anagramModel"
    }
}

