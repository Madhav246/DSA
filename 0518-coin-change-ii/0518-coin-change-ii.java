class Solution {

    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];

        for (int target = 0; target <= amount; target++) {
            if (target % coins[0] == 0) {
                prev[target] = 1;
            }
        }

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = prev[target];
                int take = 0;
                if (coins[index] <= target) {
                    take = curr[target - coins[index]];
                }

                curr[target] = take + notTake;
            }
            prev = curr.clone();
        }

        return prev[amount];
    }
}
