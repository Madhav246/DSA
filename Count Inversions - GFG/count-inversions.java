//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
       return mergeSort(arr, 0, (int)N-1);
    }
    
    static long mergeSort(long[] arr, int left, int right){
        long count = 0;
        if(left < right){
            int mid =  (left + right) / 2;
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            
            count += merge(arr, left, mid, right);
        }
        
        return count;
    }
    
    static long merge(long[] arr, int left, int mid, int right){
       int len1 = mid - left + 1;
       int len2 = right - mid;
       
       long[] arr1 = new long[len1];
       long[] arr2 = new long[len2];
       
       int k = left;
       
       for(int i=0; i<len1; i++){
           arr1[i] = arr[k++];
       }
       
       k = mid + 1;
       for(int i=0; i<len2; i++){
           arr2[i] = arr[k++];
       }
       
       int i = 0, j = 0;
       k = left;
       long count = 0;
       
       while(i < len1 && j < len2){
           if(arr1[i] <= arr2[j]){
               arr[k++] = arr1[i++];
           }
           else{
               arr[k++] = arr2[j++];
               count += (len1 - i);
           }
       }
       
       while(i < len1){
           arr[k++] = arr1[i++];
       }
       
       while(j < len2){
           arr[k++] = arr2[j++];
       }
       
       return count;
    }
}








