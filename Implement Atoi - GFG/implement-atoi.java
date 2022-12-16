//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
        
        int result = 0;
        int sign = 1;
        int j = 0;
        
        if(str.charAt(j) == '-'){
            sign = -1;
            j++;
        }
        
        for(int i=j; i<str.length(); i++){
            char ch = str.charAt(i);
            
            if(ch - '0' >= 0 && ch - '0' <= 9){
                result = result*10 + ch - '0';
            }
            else {
                return -1;
            }
        }
        if(sign == -1){
            return sign * result;
        }
        return result;
    }
}
