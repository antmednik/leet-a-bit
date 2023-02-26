package edu.mednikov.matrix

import java.util.BitSet

class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rowSets = Array(9) { _ -> BitSet(9) }
        val columnSets = Array(9) { _ -> BitSet(9) }
        val boxSets = Array(9) { _ -> BitSet(9) }
        for (rowIdx in 0..8) {
            for (columnIdx in 0..8) {
                val char = board[rowIdx][columnIdx]
                if (char != '.') {
                    val digit = char - '0'
                    if (rowSets[rowIdx].get(digit)) {
                        return false
                    }
                    rowSets[rowIdx].set(digit)
                    if (columnSets[columnIdx].get(digit)) {
                        return false
                    }
                    columnSets[columnIdx].set(digit)
                    val boxIdx = getBoxIdx(rowIdx, columnIdx)
                    if (boxSets[boxIdx].get(digit)) {
                        return false
                    }
                    boxSets[boxIdx].set(digit)
                }
            }
        }
        return true
    }

    private fun getBoxIdx(rowIdx: Int, columnIdx: Int): Int {
        if (rowIdx < 3) {
            if (columnIdx < 3) return 0
            if (columnIdx < 6) return 1
            return 2
        } else if (rowIdx < 6) {
            if (columnIdx < 3) return 3
            if (columnIdx < 6) return 4
            return 5
        } else {
            if (columnIdx < 3) return 6
            if (columnIdx < 6) return 7
            return 8
        }
    }
}