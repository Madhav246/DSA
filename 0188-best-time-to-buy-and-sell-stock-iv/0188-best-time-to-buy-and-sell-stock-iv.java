class Solution {
//Space Optimization :
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[] ahead = new int[2 * k + 1];
        int[] curr = new int[2 * k + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int transactionNo = 2 * k - 1; transactionNo >= 0; transactionNo--) {
                if (transactionNo % 2 == 0) { //Buy
                    curr[transactionNo] = Math.max(-prices[index] + ahead[transactionNo + 1], 0 + ahead[transactionNo]);
                } else { //Sell
                    curr[transactionNo] = Math.max(prices[index] + ahead[transactionNo + 1], 0 + ahead[transactionNo]);
                }
            }
            ahead = curr;
        }

        return ahead[0];
    }
}
