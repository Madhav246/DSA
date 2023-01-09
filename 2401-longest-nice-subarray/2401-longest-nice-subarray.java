class Solution {

    public int longestNiceSubarray(int[] nums) {
        int size = nums.length;
        int i = 0, j = 0;
        int count = 1, sum = 0;

        while (j < size) {
            while ((nums[j] & sum) != 0) {
                sum -= nums[i];
                i++;
            }

            sum += nums[j];

            count = Math.max(count, j - i + 1);
            j++;
        }

        return count;
    }
}
