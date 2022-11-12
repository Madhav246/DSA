class Solution {

    public int solve(int r1, int c1, int r2, int c2, int n, int[][] grid, int[][][][] dp) {
        if (r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -(int) 1e8;
        }

        if (dp[r1][c1][r2][c2] != -1) {
            return dp[r1][c1][r2][c2];
        }

        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (r2 == n - 1 && c2 == n - 1) {
            return grid[r2][c2];
        }

        int cherries;

        if (r1 == r2 && c1 == c2) {
            cherries = grid[r1][c1];
        } else {
            cherries = grid[r1][c1] + grid[r2][c2];
        }

        int downDown = solve(r1 + 1, c1, r2 + 1, c2, n, grid, dp);
        int downRight = Math.max(downDown, solve(r1 + 1, c1, r2, c2 + 1, n, grid, dp));
        int rightDown = Math.max(downRight, solve(r1, c1 + 1, r2 + 1, c2, n, grid, dp));
        int rightRight = Math.max(rightDown, solve(r1, c1 + 1, r2, c2 + 1, n, grid, dp));

        cherries += rightRight;

        return dp[r1][c1][r2][c2] = cherries;
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        int[][][][] dp = new int[n][n][n][n];

        for (int[][][] row1 : dp) {
            for (int[][] row2 : row1) {
                for (int[] row3 : row2) {
                    Arrays.fill(row3, -1);
                }
            }
        }

        return Math.max(0, solve(0, 0, 0, 0, n, grid, dp));
    }
}
