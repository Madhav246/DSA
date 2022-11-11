class Solution {

    public int solve(int i, int j, int[][] matrix, int[][] dp) {
        if (j < 0 || j >= matrix[0].length) {
            return (int) 1e9;
        }

        if (i == 0) {
            return matrix[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = matrix[i][j] + solve(i - 1, j, matrix, dp);
        int leftDiagonal = matrix[i][j] + solve(i - 1, j - 1, matrix, dp);
        int rightDiagonal = matrix[i][j] + solve(i - 1, j + 1, matrix, dp);

        return dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int mini = Integer.MAX_VALUE;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int j = 0; j < n; j++) {
            mini = Math.min(solve(n - 1, j, matrix, dp), mini);
        }

        return mini;
    }
}
