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

    public void inorder(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        
        int n = ans.size();
        int i = 0;
        int j = n - 1;
        
        while(i < j){
            int sum = ans.get(i) + ans.get(j);
            
            if(sum == k){
                return true;
            }
            
            if(sum < k){
                i++;
            }
            else{
                j--;
            }
        }
        
        return false;
    }
}





























