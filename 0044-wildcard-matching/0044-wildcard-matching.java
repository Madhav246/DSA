class Solution {

    //     public boolean solve(int i, int j, String pattern, String text, boolean[][] dp) {
    //         if (i < 0 && j < 0) {
    //             return true;
    //         }

    //         if (i < 0 && j >= 0) {
    //             return false;
    //         }

    //         if (i >= 0 && j < 0) {
    //             for (int ii = 0; ii <= i; ii++) {
    //                 if (pattern.charAt(ii) != '*') {
    //                     return false;
    //                 }
    //             }

    //             return true;
    //         }

    //         if (dp[i][j] == true) {
    //             return true;
    //         }

    //         if (pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?') {
    //             return solve(i - 1, j - 1, pattern, text, dp);
    //         }

    //         if (pattern.charAt(i) == '*') {
    //             return dp[i][j] = (solve(i - 1, j, pattern, text, dp) == true || solve(i, j - 1, pattern, text, dp) == true) ? true : false;
    //         }

    //         return false;
    //     }

    public boolean isMatch(String text, String pattern) {
        int n = pattern.length();
        int m = text.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        for (boolean[] row : dp) {
            Arrays.fill(row, false);
        }

        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int ii = 1; ii <= i; ii++) {
                if (pattern.charAt(ii - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pattern.charAt(i - 1) == text.charAt(j - 1) || pattern.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(i - 1) == '*') {
                    dp[i][j] = (dp[i - 1][j] == true || dp[i][j - 1] == true) ? true : false;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
}
