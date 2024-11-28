package edu.mednikov.trie

/**
 * https://leetcode.com/problems/word-break/
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a
 * space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 * Constraints:
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
class WordBreak139 {
    // ToDo: return to this task
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        return wordBreak0(s, wordDict)
    }

    private fun wordBreak0(s: String, wordDict: List<String>): Boolean {
        val trie = buildTrie(wordDict)
        return searchTrie(trie, trie, s, 0)
    }

    private fun buildTrie(wordDict: List<String>): TrieNode {
        val root = TrieNode()
        wordDict.forEach { word ->
            var currNode = root
            for (i in word.indices) {
                val ch = word[i]
                val nextNode = currNode.children[ch]
                if (nextNode == null) {
                    currNode.children[ch] = TrieNode(i == word.length - 1)
                    currNode = currNode.children[ch]!!
                } else {
                    if (i == word.length - 1) {
                        nextNode.endOfWord = true
                    }
                    currNode = nextNode
                }
            }
        }
        return root
    }

    private fun searchTrie(root: TrieNode, currNode: TrieNode, s: String, sIdx: Int): Boolean {
        if (currNode.endOfWord) {
            if (searchTrie(root, root, s, sIdx)) {
                return true
            }
        }
        val ch = s[sIdx]
        val nextNode = currNode.children[ch] ?: return false
        if (sIdx == s.length - 1) {
            return nextNode.endOfWord
        }
        return searchTrie(root, nextNode, s, sIdx + 1)
    }

    private data class TrieNode(
        var endOfWord: Boolean = false,
        val children: MutableMap<Char, TrieNode> = mutableMapOf()
    )
}