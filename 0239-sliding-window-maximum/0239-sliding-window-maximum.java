class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int j = 0;

        for (int i = 0; i < n; i++) {
            //Remove numbers out of range of k :
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            //Remove smaller elements :
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            if (i >= k - 1) {
                ans[j++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}
