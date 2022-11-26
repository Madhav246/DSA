//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int nums[], int n) 
	{ 
	    int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        int sum = totalSum;
        boolean[][] dp = new boolean[n][sum + 1];

        for (boolean[] row: dp) {
            Arrays.fill(row, false);
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= sum) dp[0][nums[0]] = true;

        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= sum; target++) {
                boolean notTake = dp[index - 1][target];

                boolean take = false;
                if (target >= nums[index]) {
                    take = dp[index - 1][target - nums[index]];
                }

                dp[index][target] = take || notTake;
            }
        }

        int mini = (int) 1e9;
        
        for (int s1 = 0; s1 <= totalSum / 2; s1++) {
            if (dp[n - 1][s1] == true) {
                mini = Math.min(mini, (totalSum - s1) - s1);
            }
        }

        return mini;

	} 
}
