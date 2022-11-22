class Solution {
    public int solve(int index, int transactionNo, int[] prices, int n, int k, int[][] dp){
        if(index == n || transactionNo == 2 * k){
            return 0;
        }
        
        if(dp[index][transactionNo] != -1){
            return dp[index][transactionNo];
        }
        
        int profit = 0;
        if(transactionNo % 2 == 0){
            profit += Math.max(-prices[index] + solve(index + 1, transactionNo + 1, prices, n, k, dp),
                       0 + solve(index + 1, transactionNo, prices, n, k, dp));
        }
        
        else{
            profit += Math.max(prices[index] + solve(index + 1, transactionNo + 1, prices, n, k, dp),
                       0 + solve(index + 1, transactionNo, prices, n, k, dp));
        }
        
        return dp[index][transactionNo] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        
        int[][] dp = new int[n][2 * k];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return solve(0, 0, prices, n, k, dp);
    }
}