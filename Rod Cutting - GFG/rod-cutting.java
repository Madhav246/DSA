//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int solve(int index, int n, int[] price, int[][] dp){
        if(index == 0){
            return n * price[index];
        }
        
        if(dp[index][n] != -1){
            return dp[index][n];
        }
        
        int notTake = 0 + solve(index - 1, n, price, dp);
        int take = 0;
        int rodLength = index + 1;
        if(rodLength <= n){
            take = price[index] + solve(index, n - rodLength, price, dp);
        }
        
        return dp[index][n] = Math.max(notTake, take);
    }
    
    
    public int cutRod(int price[], int n) {
        int N = price.length;
        int[][] dp = new int[N][n + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(N - 1, n, price, dp);
    }
}