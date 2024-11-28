package edu.mednikov.trie

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ImplementTrie208Test {

    @Test
    fun test1() {
        val trie = ImplementTrie208.Trie()
        assertEquals(false, trie.search("a"))
        assertEquals(false, trie.startsWith("a"))

        trie.insert("a")
        assertEquals(true, trie.search("a"))
        assertEquals(true, trie.startsWith("a"))
        assertEquals(false, trie.search("b"))
        assertEquals(false, trie.startsWith("b"))
        assertEquals(false, trie.search("ab"))
        assertEquals(false, trie.startsWith("ab"))

        trie.insert("bcde")
        assertEquals(true, trie.search("bcde"))
        assertEquals(false, trie.search("bcd"))
        assertEquals(false, trie.search("bcdef"))
        assertEquals(true, trie.startsWith("bcde"))
        assertEquals(true, trie.startsWith("bcd"))
        assertEquals(false, trie.startsWith("bcdef"))

        trie.insert("bcd")
        assertEquals(true, trie.search("bcd"))
    }
}