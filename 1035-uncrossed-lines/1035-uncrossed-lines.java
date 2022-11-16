class Solution {

    public int solve(int i, int j, int[] nums1, int[] nums2, int[][] dp) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (nums1[i] == nums2[j]) {
            return dp[i][j] = 1 + solve(i + 1, j + 1, nums1, nums2, dp);
        }

        return dp[i][j] = Math.max(solve(i, j + 1, nums1, nums2, dp), solve(i + 1, j, nums1, nums2, dp));
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, nums1, nums2, dp);
    }
}
