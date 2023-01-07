class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalBalance = 0;
        int currBalance = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            currBalance += gas[i] - cost[i];
            totalBalance += gas[i] - cost[i];

            if (currBalance < 0) {
                currBalance = 0;
                start = i + 1;
            }
        }

        if (totalBalance < 0) {
            return -1;
        }

        return start;
    }
}
