//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
    
    public void sortedInsert(Stack<Integer> s,int num){
        if(s.empty() || s.peek() < num){
            s.push(num);
            return;
        }
        
        int n = s.pop();
        sortedInsert(s, num);
        s.push(n);
    }
    
    public void sortStack(Stack<Integer> s){
        if(s.empty()){
		    return;
		}
		
		int num = s.pop();
		sortStack(s);
		sortedInsert(s, num);
    }
    
	public Stack<Integer> sort(Stack<Integer> s)
	{
		sortStack(s);
		return s;
	}
}