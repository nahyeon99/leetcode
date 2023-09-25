package leetcode.BestTimeToBuyAndSellStock;

class Solution {

    public int maxProfit(int[] prices) {

        int nowBestPrice = Integer.MAX_VALUE;
        int todayProfit = 0;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < nowBestPrice) {
                nowBestPrice = prices[i];
            }
            todayProfit = prices[i] - nowBestPrice;
            if (result < todayProfit) {
                result = todayProfit;
            }
        }
        return result;
    }
}