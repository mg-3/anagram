package com.example.assignment.anagram

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class Permutations {

    private val wordSet = mutableSetOf<String>()

    fun clearSet() {
        wordSet.clear()
    }

    fun perm2(s: String) : MutableSet<String> {
        if (s.length > 10) throw UnsupportedOperationException("This algorithm only supports strings up to length of 10")
        val n = s.length
        val a = CharArray(n)
        for (i in 0 until n)
            a[i] = s[i]
        perm2(a, n)
        return wordSet
    }

    // swap the characters at indices i and j
    private fun swap(a: CharArray, i: Int, j: Int) {
        val c = a[i]
        a[i] = a[j]
        a[j] = c
    }

    private fun perm2(a: CharArray, n: Int) {
        if (n == 1) {
            wordSet += String(a)
            return
        }

        for (i in 0 until n) {
            swap(a, i, n - 1)
            perm2(a, n - 1)
            swap(a, i, n - 1)
        }
    }

}