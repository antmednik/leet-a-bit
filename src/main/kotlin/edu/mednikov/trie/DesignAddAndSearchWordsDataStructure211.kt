package edu.mednikov.trie

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 *
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
 * word may contain dots '.' where dots can be matched with any letter.
 *
 *
 * Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 25
 * word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters.
 * There will be at most 2 dots in word for search queries.
 * At most 10^4 calls will be made to addWord and search.
 */
class DesignAddAndSearchWordsDataStructure211 {
    class WordDictionary {

        private val root = TrieNode()

        fun addWord(word: String) {
            var currNode: TrieNode = root
            for (ch in word) {
                val idx = ch - 'a'
                if (currNode.children[idx] == null) {
                    currNode.children[idx] = TrieNode()
                }
                currNode = currNode.children[idx]!!
            }
            currNode.isWord = true
        }

        fun search(word: String): Boolean {
            return search(word, 0, root)
        }

        private fun search(word: String, i: Int, node: TrieNode): Boolean {
            if (i == word.length) return node.isWord

            val ch = word[i]
            if (ch == '.') {
                for (childIdx in 0..25) {
                    val child = node.children[childIdx] ?: continue
                    if (search(word, i + 1, child)) {
                        return true
                    }
                }
                return false
            } else {
                val idx = ch - 'a'
                val nextNode = node.children[idx] ?: return false
                return search(word, i + 1, nextNode)
            }
        }

        private class TrieNode(
            var isWord: Boolean = false,
            val children: Array<TrieNode?> = arrayOfNulls(26)
        )
    }
}