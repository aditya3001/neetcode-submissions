class Solution {
    public int maxProfit(int[] prices) {

         int buy = 0;
        int maxP = 0;

        for(int sell = 1; sell < prices.length ; sell++){

            if(prices[sell] > prices[buy] ){

                int profit = prices[sell] - prices[buy];
                maxP = Math.max(profit,maxP);

            }else{
                buy = sell;
            }

        }        

        return maxP;

    }
}
