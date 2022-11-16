class Solution {

    public int solve(int i, int j, String word1, String word2, int[][] dp) {
        if (i < 0) {
            return j + 1;
        }

        if (j < 0) {
            return i + 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = solve(i - 1, j - 1, word1, word2, dp);
        }

        int insert = 1 + solve(i, j - 1, word1, word2, dp);
        int delete = Math.min(insert, 1 + solve(i - 1, j, word1, word2, dp));
        int replace = Math.min(delete, 1 + solve(i - 1, j - 1, word1, word2, dp));

        int ans = (int) 1e8;
        ans = Math.min(ans, replace);

        return dp[i][j] = ans;
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, m - 1, word1, word2, dp);
    }
}
