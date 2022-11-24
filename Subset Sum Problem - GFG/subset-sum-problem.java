//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean[] prev = new boolean[sum + 1];
        boolean[] curr = new boolean[sum + 1];
        
        prev[0] = curr[0] = true;
        
        prev[arr[0]] = true;
        
        for(int index = 1; index < N; index ++){
            for(int target = 1; target <= sum; target ++){
                boolean notTake = prev[target];
        
                boolean take = false;
                if(target >= arr[index]){
                    take = prev[target - arr[index]];
                }
                
                curr[target] = take || notTake;
            }
            prev = curr.clone();
        }
        
        return prev[sum];
    }
}