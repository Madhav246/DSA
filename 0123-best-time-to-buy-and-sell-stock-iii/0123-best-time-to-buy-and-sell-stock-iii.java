class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int transactionCount = 1; transactionCount <= 2; transactionCount++) {
                    if (canBuy == 1) {
                        dp[index][canBuy][transactionCount] = Math.max(-prices[index] + dp[index + 1][0][transactionCount], 0 + dp[index + 1][1][transactionCount]);
                    } else {
                        dp[index][canBuy][transactionCount] = Math.max(prices[index] + dp[index + 1][1][transactionCount - 1], 0 + dp[index + 1][0][transactionCount]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}
