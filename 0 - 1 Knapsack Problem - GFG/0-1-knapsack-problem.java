//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int[][] dp = new int[n][W + 1];
         
         //Base Case :
         for(int i = wt[0]; i<=W; i++){
             dp[0][i] = val[0];
         }
         
         for(int index = 1; index < n; index++){
             for(int weight = 0; weight<=W; weight++){
                    int notTake = 0 + dp[index - 1][weight];
                    int take = 0;
                    if(wt[index] <= weight){
                        take += val[index] + dp[index - 1][weight - wt[index]];
                    }
                    
                    dp[index][weight] = Math.max(take, notTake);
             }
         }
         
         return dp[n - 1][W];
    } 
}


