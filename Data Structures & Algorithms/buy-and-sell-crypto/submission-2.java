class Solution {
    public int maxProfit(int[] prices) {

        int start = 0;
        int end = 0;
        int profit = 0;

        while (end < prices.length) {
            if (prices[end] > prices[start]) {
                profit = Math.max(prices[end] - prices[start], profit);
            } else {
                start = end;
            }
            end++;

        }
        return profit;

    }
}
