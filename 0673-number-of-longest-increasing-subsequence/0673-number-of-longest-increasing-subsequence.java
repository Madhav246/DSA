class Solution {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);

        int maxi = 1;

        for (int index = 0; index < n; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                if (nums[index] > nums[prevIndex] && 1 + dp[prevIndex] > dp[index]) {
                    dp[index] = 1 + dp[prevIndex];
                    cnt[index] = cnt[prevIndex];
                } else if (nums[index] > nums[prevIndex] && 1 + dp[prevIndex] == dp[index]) {
                    cnt[index] += cnt[prevIndex];
                }
            }

            maxi = Math.max(maxi, dp[index]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi) {
                ans += cnt[i];
            }
        }

        return ans;
    }
}
