package leetcode.BestTimeToBuyAndSellStock2;

class Solution {
    public int maxProfit(int[] prices) {

        int hold = Integer.MIN_VALUE;
        int notHold = 0;

        for (int price : prices) {
            int prevHold = hold;
            int prevNotHold = notHold;

            hold = Math.max(prevHold, prevNotHold - price);

            notHold = Math.max(prevNotHold, prevHold + price);
        }
        return notHold;
    }
}