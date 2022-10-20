class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalBalance = 0;
        int balance = 0;
        int start = 0;
        int n = gas.length;

        for (int i = 0; i < n; i++) {
            balance += gas[i] - cost[i];
            totalBalance += gas[i] - cost[i];

            if (balance < 0) {
                balance = 0;
                start = i + 1;
            }
        }

        if (totalBalance >= 0) {
            return start;
        } else {
            return -1;
        }
    }
}
