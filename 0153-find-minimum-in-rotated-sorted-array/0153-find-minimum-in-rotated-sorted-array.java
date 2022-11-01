class Solution {

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;

        while (start < end) {
            if (nums[mid] > nums[end]) { //means mid is on first line
                start = mid + 1;
            } else {
                end = mid;
            }
            mid = start + (end - start) / 2;
        }
        return nums[end];
    }
}
