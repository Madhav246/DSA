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
    public int cutRod(int price[], int n) {
        int N = price.length;
        int[][] dp = new int[N][n + 1];
        
        for(int i=0; i<=n; i++){
            dp[0][i] = i * price[0];
        }
        
        for(int index = 1; index < N; index ++){
            for(int totalLength = 0; totalLength<=n; totalLength++){
                int notTake = 0 + dp[index - 1][totalLength];
                int take = 0;
                int rodLength = index + 1;
                if(rodLength <= totalLength){
                    take = price[index] + dp[index][totalLength - rodLength];
                }
        
                dp[index][totalLength] = Math.max(notTake, take);
            }
        }
        
        
        return dp[N - 1][n];
    }
}