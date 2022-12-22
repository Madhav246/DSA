/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preOrderIndex;
    
    public void createMapping(int[] inorder, HashMap<Integer, Integer> map, int n){
        for(int i=0; i<n; i++){
            map.put(inorder[i], i);
        }
    }
    
    public TreeNode solve(int[] inorder, int[] preorder, int inorderStart, int inorderEnd, int preorderEnd, HashMap<Integer, Integer> map){
        
        if(preOrderIndex >= preorderEnd || inorderStart > inorderEnd){
            return null;
        }
        
        int element = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(element);
        
        int position = map.get(element);
     
        root.left = solve(inorder, preorder, inorderStart, position - 1, preorderEnd, map);
        root.right = solve(inorder, preorder, position + 1, inorderEnd, preorderEnd, map);
        
        return root;
    }
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;
        int n = preorder.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        createMapping(inorder, map, n);
        
        TreeNode root = solve(inorder, preorder, 0, n - 1, n, map);
        return root;
        
    }
}