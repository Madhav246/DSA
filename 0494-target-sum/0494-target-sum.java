class Solution {

    public int solve(int index, int n, int[] arr, int target, int[][] dp) {
        if (index == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTake = solve(index - 1, n, arr, target, dp);

        int take = 0;
        if (target >= arr[index]) {
            take = solve(index - 1, n, arr, target - arr[index], dp);
        }

        return dp[index][target] = (take + notTake);
    }

    public int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        int sum = (totalSum - d) / 2;
        if (totalSum - d < 0 || (totalSum - d) % 2 != 0) {
            return 0;
        }

        int[][] dp = new int[n][sum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, n, arr, sum, dp);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums.length, target, nums);
    }
}
