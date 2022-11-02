//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    public static boolean isPossibleSolu(int[] v, int n, int k, int mid){
        int cowCount = 1;
        int lastPos = v[0];
        
        for(int i=0; i<n; i++){
            if(v[i] - lastPos >= mid){
                cowCount++;
                if(cowCount == k){
                    return true;
                }
                lastPos = v[i];
            }
        }
        return false;
    }
    
    public static int solve(int n, int k, int[] v) {
        Arrays.sort(v);
        int start = 0;
        int end = v[v.length - 1];
        int mid = start + (end - start) / 2;
        int ans = -1;
        
        while(start <= end){
            if(isPossibleSolu(v, n, k, mid)){
                ans = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return ans;
    }
}