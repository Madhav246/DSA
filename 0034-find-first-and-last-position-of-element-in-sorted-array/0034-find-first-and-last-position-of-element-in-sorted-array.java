class Solution {

    public static int firstOccur(int[] arr, int start, int end, int k) {
        int index = -1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (arr[mid] == k) {
                end = mid - 1;
                index = mid;
            } else if (k > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return index;
    }

    public static int lastOccur(int[] arr, int start, int end, int k) {
        int mid = start + (end - start) / 2;
        int index = -1;

        while (start <= end) {
            if (arr[mid] == k) {
                start = mid + 1;
                index = mid;
            } else if (k > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return index;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        ans[0] = firstOccur(nums, 0, nums.length - 1, target);
        ans[1] = lastOccur(nums, 0, nums.length - 1, target);

        return ans;
    }
}
