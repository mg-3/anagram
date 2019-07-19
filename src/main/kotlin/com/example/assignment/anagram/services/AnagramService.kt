package com.example.assignment.anagram.services

/**
 * Anagram service implementation that finds anagrams for a given word. Also
 * manages the in-memory database of words to check against.
 *
 */
interface AnagramService {

    /**
     * Check whether the two words are anagrams or not
     *
     * @param word the first word
     * @return the set of anagrams
     */
    fun isAnagram(word: String) : Set<String>

    /**
     * Add a word to the dictionary
     *
     * @param words the word(s) to add
     */
    fun addToCorpus(words: List<String>)

    /**
     * Remove one or all words from the dictionary
     *
     * @param all whether to remove all words or not - default is false
     * @param word a word to delete from the dictionary - default is empty string
     */
    fun removeFromCorpus(all: Boolean = false, word: String = "")
}