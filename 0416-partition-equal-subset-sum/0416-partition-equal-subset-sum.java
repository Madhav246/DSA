class Solution {
    public boolean isSubsetSum(int index, int n, int[] nums, int target, int[][] dp) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return nums[0] == target;
        }

        if (dp[index][target] != -1) {
            return dp[index][target] == 1 ? true : false;
        }

        boolean notTake = isSubsetSum(index - 1, n, nums, target, dp);

        boolean take = false;
        if (target >= nums[index]) {
            take = isSubsetSum(index - 1, n, nums, target - nums[index], dp);
        }

        dp[index][target] = take || notTake ? 1 : 0;

        return take || notTake;
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int[][] dp = new int[nums.length][(totalSum / 2) + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return isSubsetSum(nums.length - 1, nums.length, nums, totalSum / 2, dp);
    }
}
