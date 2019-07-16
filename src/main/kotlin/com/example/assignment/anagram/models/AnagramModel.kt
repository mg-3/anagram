package com.example.assignment.anagram.models

data class AnagramModel(val anagrams: Array<String>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AnagramModel

        if (!anagrams.contentEquals(other.anagrams)) return false

        return true
    }

    override fun hashCode(): Int {
        return anagrams.contentHashCode()
    }
}
