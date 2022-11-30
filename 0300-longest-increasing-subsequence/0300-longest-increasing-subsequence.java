class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {
                int notTake = 0 + dp[index + 1][prevIndex + 1];
                int take = 0;
                if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
                    take = 1 + dp[index + 1][index + 1];
                }

                int len = Math.max(take, notTake);
                dp[index][prevIndex + 1] = len;
            }
        }

        return dp[0][-1 + 1];
    }
}
