package com.example.assignment.anagram.services.impl

import com.example.assignment.anagram.Permutations
import com.example.assignment.anagram.services.AnagramService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * The anagram implementation service
 *
 * @see [AnagramService]
 */
@Service
class AnagramServiceImpl(
        @Autowired val dictionarySet: MutableSet<String>,
        @Autowired val permutations: Permutations
) : AnagramService {

    private val logger = LoggerFactory.getLogger(AnagramServiceImpl::class.java)

    override fun addToCorpus(words: List<String>) {
        logger.info("ADD $words to corpus")
        if (dictionarySet.addAll(words)) {
            logger.info("$words added to dictionary")
        }
    }

    override fun removeFromCorpus(all: Boolean, word: String) {
        if (all) {
            dictionarySet.clear()
            logger.info("DELETE all")
        }
        if (word.isNotEmpty()) {
            if (dictionarySet.remove(word)) {
                logger.info("DELETE $word ")
            }
        }
    }

    /**
     * First find all the permutations of a word. Then filter out only those that are in the
     * in-memory database.
     *
     * [AnagramService.isAnagram]
     */
    override fun isAnagram(word: String) : Set<String> {
        logger.info("FIND for $word")
        val result = permutations.perm2(word)
                .filter { w -> dictionarySet.contains(w) }
                .filter { w -> w != word }
                .toSet()
        permutations.clearSet()
        return result
    }
}
