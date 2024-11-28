package edu.mednikov.trie

import edu.mednikov.trie.DesignAddAndSearchWordsDataStructure211.WordDictionary
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue


class DesignAddAndSearchWordsDataStructure211Test {
    @Test
    fun test1() {
        val wordDictionary = WordDictionary()
        wordDictionary.addWord("bad")
        wordDictionary.addWord("dad")
        wordDictionary.addWord("mad")
        assertFalse(wordDictionary.search("pad"))
        assertTrue(wordDictionary.search("bad"))
        assertTrue(wordDictionary.search(".ad"))
        assertTrue(wordDictionary.search("b.."))
    }

    @Test
    fun test2() {
        val wordDictionary = WordDictionary()
        assertEquals(false, wordDictionary.search("a"))

        wordDictionary.addWord("a")
        assertEquals(true, wordDictionary.search("a"))
        assertEquals(true, wordDictionary.search("."))
        assertEquals(false, wordDictionary.search("b"))
        assertEquals(false, wordDictionary.search("ab"))
        assertEquals(false, wordDictionary.search("a."))

        wordDictionary.addWord("bcde")
        assertEquals(true, wordDictionary.search("bcde"))
        assertEquals(false, wordDictionary.search("bcd"))
        assertEquals(false, wordDictionary.search("bc."))
        assertEquals(false, wordDictionary.search("b.d"))
        assertEquals(true, wordDictionary.search("bcd."))
        assertEquals(true, wordDictionary.search("bc.."))
        assertEquals(true, wordDictionary.search("b.d."))
        assertEquals(true, wordDictionary.search("...."))
        assertEquals(false, wordDictionary.search("bcdef"))

        wordDictionary.addWord("bcd")
        assertEquals(true, wordDictionary.search("bcd"))
        assertEquals(true, wordDictionary.search("bc."))
        assertEquals(true, wordDictionary.search("b.d"))
    }
}