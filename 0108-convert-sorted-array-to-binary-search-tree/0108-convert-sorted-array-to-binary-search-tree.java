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
    
    public TreeNode solve(int start, int end, int[] nums){
        if(start > end){
            return null;
        }
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = solve(start, mid - 1, nums);
        root.right = solve(mid + 1, end, nums);
        
        return root;
        
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(0, nums.length - 1, nums);
    }
}