class Solution {
//Space Optimization :
    public int maxProfit(int[] prices) {
        int n = prices.length;
       int[][] after = new int[2][3];
       int[][] curr = new int[2][3];

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int transactionCount = 1; transactionCount <= 2; transactionCount++) {
                    
                    if (canBuy == 1) {
                        curr[canBuy][transactionCount] = Math.max(-prices[index] + after[0][transactionCount], 0 + after[1][transactionCount]);
                    } 
                    
                    else {
                        curr[canBuy][transactionCount] = Math.max(prices[index] + after[1][transactionCount - 1], 0 + after[0][transactionCount]);
                    }
                    
                }
                after = curr;
            }
        }
        return after[1][2];
    }
}
