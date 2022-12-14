//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    
    boolean isLeaf(Node root){
        if(root.left == null && root.right == null) return true;
        return false;
    }
    
    void addLeftBoundary(Node root, ArrayList<Integer> ans){
        Node current = root.left;
        
        while(current != null){
            if(isLeaf(current) == false) ans.add(current.data);
            if(current.left != null) current = current.left;
            else current = current.right;
        }
    }
    
    void addLeaf(Node root, ArrayList<Integer> ans){
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        if(root.left != null) addLeaf(root.left, ans);
        if(root.right != null) addLeaf(root.right, ans);
    }
    
    void addRightBoundary(Node root, ArrayList<Integer> ans){
        Node current = root.right;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        while(current != null){
            if(isLeaf(current) == false) temp.add(current.data);
            if(current.right != null) current = current.right;
            else current = current.left;
        }
        
        for(int i=temp.size() - 1; i>=0; i--){
            ans.add(temp.get(i));
        }
        
    }
    
	ArrayList <Integer> boundary(Node node) {
	    ArrayList<Integer> res = new ArrayList<>();
	    if(isLeaf(node) == false) res.add(node.data);
	    addLeftBoundary(node, res);
	    addLeaf(node, res);
	    addRightBoundary(node, res);
	    
	    return res;
	}
}
