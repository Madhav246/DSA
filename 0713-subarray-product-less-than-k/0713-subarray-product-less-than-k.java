class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1;
        int i = 0, j = 0;
        int ans = 0;

        while (j < nums.length) {
            prod *= nums[j];

            while (prod >= k) {
                prod /= nums[i++];
            }

            ans += (j - i + 1);
            j++;
        }

        return ans;
    }
}
