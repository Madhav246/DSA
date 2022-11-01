class Solution {

    public int findPivot(int[] nums, int n) {
        int start = 0;
        int end = n - 1;
        int mid = start + (end - start) / 2;

        while (start < end) {
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
            mid = start + (end - start) / 2;
        }
        return end;
    }

    public int binarySearch(int[] nums, int start, int end, int key) {
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (nums[mid] == key) {
                return mid;
            } else if (key < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums, n);
        if (target >= nums[pivot] && target <= nums[n - 1]) {
            return binarySearch(nums, pivot, n - 1, target);
        } else {
            return binarySearch(nums, 0, pivot - 1, target);
        }
    }
}
