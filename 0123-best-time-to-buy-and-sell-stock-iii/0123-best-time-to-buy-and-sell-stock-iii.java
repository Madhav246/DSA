class Solution {

    public int solve(int index, int n, int[] prices, int canBuy, int transactionCount, int[][][] dp) {
        if (index == n || transactionCount == 0) {
            return 0;
        }

        if (dp[index][canBuy][transactionCount] != -1) {
            return dp[index][canBuy][transactionCount];
        }

        int profit = 0;
        if (canBuy == 1) {
            profit += Math.max(-prices[index] + solve(index + 1, n, prices, 0, transactionCount, dp), 0 + solve(index + 1, n, prices, 1, transactionCount, dp));
        } else {
            profit += Math.max(prices[index] + solve(index + 1, n, prices, 1, transactionCount - 1, dp), 0 + solve(index + 1, n, prices, 0, transactionCount, dp));
        }

        return dp[index][canBuy][transactionCount] = profit;
    }

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];

        for (int[][] row1 : dp) {
            for (int[] row2 : row1) {
                Arrays.fill(row2, -1);
            }
        }
        return solve(0, prices.length, prices, 1, 2, dp);
    }
}
