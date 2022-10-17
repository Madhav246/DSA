//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String s)
    {
        
        if(s.length() % 2 == 1){
            return -1;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '{'){
                stack.push(ch);
            }
            
            else{
                if(!stack.empty() && stack.peek() == '{'){
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }
            }
        }
        
        int a = 0, b = 0;
        
        while(!stack.empty()){
            if(stack.peek() == '{'){
                a++;
            }
            else{
                b++;
            }
            stack.pop();
        }
        
        return (a+1)/2 + (b+1)/2;
        
        
    }
}