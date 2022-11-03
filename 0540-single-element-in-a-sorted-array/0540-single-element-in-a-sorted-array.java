class Solution {

    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 2;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            //Checking for Left half :
            if (mid % 2 == 0) {
                if (nums[mid] != nums[mid + 1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            //Check for right half :
            else {
                if (nums[mid] == nums[mid + 1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            mid = start + (end - start) / 2;
        }
        return nums[start];
    }
}
