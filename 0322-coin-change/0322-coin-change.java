class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];
        
        
        for(int target = 0; target<= amount; target++){
            if(target % coins[0] == 0){
                prev[target] = target / coins[0];
            }
            else{
                prev[target] = (int)1e9;
            }
        }
        
        for(int index = 1; index < n; index++){
            for(int target = 0; target<=amount; target++){
                int notTake = 0 + prev[target];
                int take = (int)1e9;
                if(coins[index] <= target){
                    take = 1 + curr[target - coins[index]];
                }

                curr[target] = Math.min(notTake, take);
            }
            prev = curr;
        }
        
        
        if(prev[amount] >= (int)1e9){
            return -1;
        } 
        return prev[amount];
    }
}