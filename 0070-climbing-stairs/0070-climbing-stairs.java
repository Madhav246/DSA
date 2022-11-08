class Solution {
//Memoization :
    public int solve(int[] dp, int index) {
        if (index == 0) {
            return 1;
        }

        if (index == 1) {
            return 1;
        }
        
        if (dp[index] != -1) {
            return dp[index];
        }

        return dp[index] = solve(dp, index - 1) + solve(dp, index - 2);
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(dp, n);
    }
}
