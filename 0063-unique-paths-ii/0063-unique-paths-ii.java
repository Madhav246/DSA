class Solution {

    //Memoization :
    public int solve(int i, int j, int[][] dp, int[][] obstacleGrid) {
        if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = solve(i - 1, j, dp, obstacleGrid);
        int left = solve(i, j - 1, dp, obstacleGrid);

        return dp[i][j] = up + left;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(m - 1, n - 1, dp, obstacleGrid);
    }
}
