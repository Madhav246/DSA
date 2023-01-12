class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int k = target;
        int i = 0, j = 0;
        int size = nums.length;
        int sum = 0;
        int mini = Integer.MAX_VALUE;
        
        
        while (j < size) {
           sum += nums[j];
            
            while(sum >= k){
                mini = Math.min(mini, j - i + 1);
                sum -= nums[i++];
            }
            
            j++;
        }

        return (mini == Integer.MAX_VALUE) ?  0 : mini;
    }
}
