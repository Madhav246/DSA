class Solution {

    public int jump(int[] nums) {
        int currReach = 0;
        int currMax = 0;
        int jumps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            currMax = Math.max(currMax, i + nums[i]);

            if (i == currReach) {
                jumps++;
                currReach = currMax;
            }
        }

        return jumps;
    }
}
