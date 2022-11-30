class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;

        for (int index = 0; index < n; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                if (nums[prevIndex] < nums[index]) {
                    dp[index] = Math.max(dp[index], 1 + dp[prevIndex]);
                }
            }

            maxi = Math.max(maxi, dp[index]);
        }

        return maxi;
    }
}
