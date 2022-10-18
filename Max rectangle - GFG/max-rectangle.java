//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int[] nextSmallerElement(int[] heights, int n){
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int[] ans = new int[n];
        
        for(int i=n-1; i>=0; i--){
            while(s.peek() != -1 && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);
        }
        return ans;
    }
    
    public int[] previousSmallerElement(int[] heights, int n){
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int[] ans = new int[n];
        
        for(int i=0; i<n; i++){
            while(s.peek() != -1 && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);
        }
        return ans;
    }
    
    
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        
        int[] next = nextSmallerElement(heights, n);

        int[] previous = previousSmallerElement(heights, n);
        
        int area = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            int l = heights[i];
            
            if(next[i] == -1){
                next[i] = n;
            }
            
            int b = next[i] - previous[i] - 1;
            int newArea = l*b;
            area = Math.max(area, newArea);   
        }   
        return area;      
    }
    
    public int maxArea(int M[][], int n, int m) {
        
        int area = largestRectangleArea(M[0]);
        
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                if(M[i][j] != 0){
                    M[i][j] = M[i][j] + M[i-1][j]; 
                }
                else{
                    M[i][j] = 0;
                }
            }
             int newArea = largestRectangleArea(M[i]);
             area = Math.max(area, newArea);
        }
        
        return area;
    }
}