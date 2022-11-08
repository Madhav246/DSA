class Solution {
//Tabulation :
    public int solve(int index, int[] nums, int[] dp) {
        dp[0] = nums[0];
        int negative = 0;

        for (int i = 1; i < index; i++) {
            int pick = nums[i];

            if (i > 1) {
                pick += dp[i - 2];
            }
            int notPick = 0 + dp[i - 1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[index - 1];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(n, nums, dp);
    }
}
