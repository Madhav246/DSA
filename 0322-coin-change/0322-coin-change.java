class Solution {
    public int solve(int index, int[] coins, int target, int[][] dp){
        if(index == 0){
            if(target % coins[index] == 0) return target / coins[index];
            else return (int)1e9;
        }
        
        if(dp[index][target] != -1){
            return dp[index][target];
        }
        
        int notTake = 0 + solve(index - 1, coins, target, dp);
        int take = (int)1e9;
        if(coins[index] <= target){
            take = 1 + solve(index, coins, target - coins[index], dp);
        }
        
        return dp[index][target] = Math.min(notTake, take);
    }
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        int ans = solve(n - 1 , coins, amount, dp);
        if(ans >= (int)1e9){
            return -1;
        } 
        return ans;
    }
}