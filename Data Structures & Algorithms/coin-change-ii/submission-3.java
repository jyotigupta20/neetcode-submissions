class Solution {
    public int change(int amount, int[] coins) {
       if(coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        Arrays.sort(coins);
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];

        
        for(int i = 0; i <= n; i++ ) {
            for(int j = 0; j<= amount; j++) {
                if(i==0) {
                     dp[i][j] = 0;
                }
                if(j==0) {
                    dp[i][j] = 1;
                }
            }
            
        }
        for(int i=n-1; i >= 0; i--) {
            for(int j = 0; j <= amount; j++) {
                    if(coins[i] <= j) {
                        dp[i][j] = dp[i+1][j] + dp[i][j-coins[i]];
                    } 
                }
            }
        
        return dp[0][amount]; 
    }
}
