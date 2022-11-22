class Solution {
    //Tabulation :
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2 * k + 1];

        for (int index = n - 1; index >= 0; index--) {
            
            for (int transactionNo = 2 * k - 1; transactionNo >= 0; transactionNo--) {
                
                if (transactionNo % 2 == 0) { //Buy
                    dp[index][transactionNo] = Math.max(-prices[index] + dp[index + 1][transactionNo + 1], 0 + dp[index + 1][transactionNo]);
                } 
                
                else { //Sell
                    dp[index][transactionNo] = Math.max(prices[index] + dp[index + 1][transactionNo + 1], 0 + dp[index + 1][transactionNo]);
                }
            }
        }
        
        return dp[0][0];
    }
}
