//{ Driver Code Starts
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
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
       int[] count = new int[26];
       Queue<Character> queue = new LinkedList<>();
       String ans = "";
       
       for(int i=0; i<A.length(); i++){
           char ch = A.charAt(i);
           
           count[ch - 'a']++;
           queue.add(ch);
           
           while(!queue.isEmpty()){
               if(count[queue.peek() - 'a'] > 1){
                   queue.remove();
               }
               else{
                  ans += queue.peek();
                  break;
               }
           }
           
           if(queue.isEmpty()){
               ans += '#';
           }
       }
       
       return ans;
    }
}