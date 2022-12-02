//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        int n = nums.length;
        
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        
        for(int index = 0; index < n; index++){
            for(int prevIndex = 0; prevIndex < index; prevIndex++){
                if(nums[prevIndex] < nums[index] && dp1[index] < 1 + dp1[prevIndex]){
                    dp1[index] = 1 + dp1[prevIndex];
                }
            }
        }
        
         int[] dp2 = new int[n];
         Arrays.fill(dp2, 1);
        
        for(int index = n - 1; index >= 0; index --){
            for(int prevIndex = n - 1; prevIndex > index; prevIndex--){
                if(nums[prevIndex] < nums[index] && dp2[index] < 1 + dp2[prevIndex]){
                    dp2[index] = 1 + dp2[prevIndex];
                }
            }
        }
        
        int maxi = 1;
        for(int i=0; i<n; i++){
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }
        return maxi;
    }
}