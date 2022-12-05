class Solution {
    public int minMoves(int[] nums) {
        int mini = (int)1e9;
        
        for(int n : nums){
            mini = Math.min(mini, n);
        }
        
        int moves = 0;
        
        for(int i=0; i<nums.length; i++){
            moves += Math.abs(nums[i] - mini);
        }
        
        return moves;
    }
}