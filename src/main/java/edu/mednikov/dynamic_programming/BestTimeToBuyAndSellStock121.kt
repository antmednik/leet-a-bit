package edu.mednikov.dynamic_programming

class BestTimeToBuyAndSellStock121 {
    fun maxProfit(prices: IntArray): Int {
        var minVal = prices[0]
        var maxProfit = 0

        for (i in prices.indices) {
            if (prices[i] < minVal) {
                minVal = prices[i]
            }
            val todayProfit = prices[i] - minVal
            if (maxProfit < todayProfit) {
                maxProfit = todayProfit
            }
        }
        return maxProfit
    }
}