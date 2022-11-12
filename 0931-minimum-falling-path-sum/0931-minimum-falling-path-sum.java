class Solution {
    //Tabulation :
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[i - 1][j];
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) 1e9;
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) 1e9;
                }

                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        int mini = dp[n - 1][0];

        for (int j = 1; j < n; j++) {
            mini = Math.min(mini, dp[m - 1][j]);
        }

        return mini;
    }
}
