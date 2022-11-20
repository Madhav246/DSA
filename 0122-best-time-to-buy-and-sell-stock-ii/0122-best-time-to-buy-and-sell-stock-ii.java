class Solution {
    //Space Optimized :
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] ahead = new int[2];
        int[] curr = new int[2];

        ahead[0] = ahead[1] = 0;
        
        for(int index=n-1; index>=0; index--){
            for(int canBuy=0; canBuy<=1; canBuy++){
                int profit = 0;
                if (canBuy == 1) {
                    profit = Math.max(-prices[index] + ahead[0], 0 + ahead[1]);
               } 
                else {
                    profit = Math.max(prices[index] + ahead[1], 0 + ahead[0]);
        }

        curr[canBuy] = profit;
            }
            ahead = curr;
        }
        
        return ahead[1];
        
    }
}
