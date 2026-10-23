class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        while(right < prices.length) {
            if(prices[left] < prices[right]) {
              maxProfit = Math.max(maxProfit, (prices[right] - prices[left]));
            } else {
              left = right;  
            }
            right++;
        }
        return maxProfit;
    }
}
