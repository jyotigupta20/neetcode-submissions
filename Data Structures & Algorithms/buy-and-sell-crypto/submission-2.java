class Solution {
    public int maxProfit(int[] prices) {
       int buy = 0;
        int maxProfit = 0;
       for(int i=1; i < prices.length; i++) {
        if(prices[buy] >= prices[i]) {
          buy = i; 
        } else {
           maxProfit = Math.max(maxProfit, prices[i] - prices[buy]);
        }
       } 
       return maxProfit;
    }
}
