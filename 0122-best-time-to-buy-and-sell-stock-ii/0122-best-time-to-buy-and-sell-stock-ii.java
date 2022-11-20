class Solution {

    public int solve(int index, int canBuy, int[] prices, int n, int[][] dp) {
        if (index == n) {
            return 0;
        }

        int profit = 0;

        if (dp[index][canBuy] != -1) {
            return dp[index][canBuy];
        }

        if (canBuy == 1) {
            profit = Math.max(-prices[index] + solve(index + 1, 0, prices, n, dp), 0 + solve(index + 1, 1, prices, n, dp));
        } else {
            profit = Math.max(prices[index] + solve(index + 1, 1, prices, n, dp), 0 + solve(index + 1, 0, prices, n, dp));
        }

        return dp[index][canBuy] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 1, prices, n, dp);
    }
}
