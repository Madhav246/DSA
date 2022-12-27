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
    int i;

    public TreeNode solve(int min, int max, int[] preorder) {
        if (i >= preorder.length) {
            return null;
        }

        if (preorder[i] < min || preorder[i] > max) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i++]);
        root.left = solve(min, root.val, preorder);
        root.right = solve(root.val, max, preorder);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        return solve(Integer.MIN_VALUE, Integer.MAX_VALUE, preorder);
    }
}
