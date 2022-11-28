class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[][] dp = new int[n][amount + 1];
        
        for(int target = 0; target<= amount; target++){
            if(target % coins[0] == 0){
                dp[0][target] = target / coins[0];
            }
            else{
                dp[0][target] = (int)1e9;
            }
        }
        
        for(int index = 1; index < n; index++){
            for(int target = 0; target<=amount; target++){
                int notTake = 0 + dp[index - 1][target];
                int take = (int)1e9;
                if(coins[index] <= target){
                    take = 1 + dp[index][target - coins[index]];
                }

                dp[index][target] = Math.min(notTake, take);
            }
        }
        
        
        if(dp[n - 1][amount] >= (int)1e9){
            return -1;
        } 
        return dp[n - 1][amount];
    }
}