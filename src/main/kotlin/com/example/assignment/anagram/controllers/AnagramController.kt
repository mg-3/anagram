package com.example.assignment.anagram.controllers

import com.example.assignment.anagram.models.Anagrams
import com.example.assignment.anagram.models.Words
import com.example.assignment.anagram.services.AnagramService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class AnagramController(
        @Autowired val anagramService: AnagramService
) {

    @RequestMapping(
            value = ["/anagrams/{word}.json"],
            method = [RequestMethod.GET],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAnagram(@PathVariable("word") word: String,
                   @RequestParam("limit", defaultValue = "0") maxResults: Int) : ResponseEntity<Anagrams> {

        val anagrams = anagramService.isAnagram(word)
        return if (maxResults > 0) {
            ResponseEntity.ok(Anagrams(anagrams.take(maxResults).toSet()))
        }
        else {
            ResponseEntity.ok(Anagrams(anagrams))
        }
    }

    @RequestMapping(
            value = ["/words.json"],
            method = [RequestMethod.POST],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun addToCorpus(@RequestBody words: Words) : ResponseEntity<Nothing> {
        anagramService.addToCorpus(words.words)
        return ResponseEntity.status(HttpStatus.CREATED).body(null)
    }

    @RequestMapping(
            value = ["/words.json", "/words/{WORD}.json"],
            method = [RequestMethod.DELETE]
    )
    fun removeFromCorpus(@PathVariable(value = "WORD", required = false) wordToDelete: Optional<String>): ResponseEntity<Nothing> {

        if (wordToDelete.isPresent) {
            anagramService.removeFromCorpus(word = wordToDelete.get())
        }
        else {
            anagramService.removeFromCorpus(all = true)
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null)
    }
}

