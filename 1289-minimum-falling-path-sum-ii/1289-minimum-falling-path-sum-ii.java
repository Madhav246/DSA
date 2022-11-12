class Solution {

    public int solve(int i, int j, int[][] grid, int[][] dp) {
        if (j < 0 || j >= grid[0].length) {
            return (int) 1e9;
        }

        if (i == 0) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int mini = (int) 1e9;
        for (int k = 0; k < grid[0].length; k++) {
            if (k == j) {
                continue;
            }

            int ans = grid[i][j] + solve(i - 1, k, grid, dp);

            mini = Math.min(mini, ans);
        }
        return dp[i][j] = mini;
    }

    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int mini = (int) 1e9;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, solve(n - 1, j, grid, dp));
        }

        return mini;
    }
}
