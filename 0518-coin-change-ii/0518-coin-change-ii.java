class Solution {

    public int solve(int index, int[] coins, int target, int[][] dp) {
        if (index == 0) {
            if (target % coins[index] == 0) return 1; else return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTake = solve(index - 1, coins, target, dp);
        int take = 0;
        if (coins[index] <= target) {
            take = solve(index, coins, target - coins[index], dp);
        }

        return dp[index][target] = take + notTake;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, coins, amount, dp);
    }
}
