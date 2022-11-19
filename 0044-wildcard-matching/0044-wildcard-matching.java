class Solution {
//Tabulation :
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
