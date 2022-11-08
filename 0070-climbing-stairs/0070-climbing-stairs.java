class Solution {

    //Space optimization :
    public int solve(int index) {
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 2; i <= index; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public int climbStairs(int n) {
        return solve(n);
    }
}
