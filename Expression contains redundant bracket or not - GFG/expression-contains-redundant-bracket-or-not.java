//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.checkRedundancy(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int checkRedundancy(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                stack.push(ch);
            }
            
            else{
                if(ch == ')'){
                    boolean isRedundant = true;
                    
                    while(stack.peek() != '('){
                        char top = stack.peek();
                        
                        if(top == '+' || top == '-' || top == '*' || top == '/'){
                            isRedundant = false;
                        }
                        
                        stack.pop();
                    }
                    
                    if(isRedundant == true){
                        return 1;
                    }
                    
                    stack.pop();
                }
            }
        }
        return 0;
    }
}
        
