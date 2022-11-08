class Solution {
//Tabulation :
    //upar se neeche jaa rahe hai !
    public int solve(int[] dp, int index) {
       dp[0] = 1;
       dp[1] = 1;
        
       for(int i=2; i<=index; i++){
           dp[i] = dp[i-1] + dp[i-2];
       }
        return dp[index];
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(dp, n);
    }
}
