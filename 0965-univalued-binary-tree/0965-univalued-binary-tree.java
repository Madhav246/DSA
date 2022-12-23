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
    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int temp = root.val;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            
            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();
                if(current.val != temp){
                    return false;
                }
                
                if(current.left != null){
                    queue.offer(current.left);
                }
                
                if(current.right != null){
                    queue.offer(current.right);
                }
            }
        }
        
        return true;
    }
}