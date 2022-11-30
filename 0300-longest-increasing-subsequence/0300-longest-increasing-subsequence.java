class Solution {

    public int solve(int index, int prevIndex, int n, int[] nums, int[][] dp) {
        if (index == n) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        int notTake = 0 + solve(index + 1, prevIndex, n, nums, dp);

        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + solve(index + 1, index, n, nums, dp);
        }

        int len = Math.max(take, notTake);
        return dp[index][prevIndex + 1] = len;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, -1, n, nums, dp);
    }
}
