class Solution {

    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int count = 1;
        int maxi = 1;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            maxi = Math.max(maxi, count);
        }

        return maxi;
    }
}
