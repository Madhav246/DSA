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
    int max = 0;

    public void solve(TreeNode root, int depth, boolean direction) {
        max = Math.max(max, depth);

        if (root == null) {
            return;
        }

        solve(root.left, direction ? depth + 1 : 0, false);
        solve(root.right, !direction ? depth + 1 : 0, true);
    }

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }

        solve(root.left, 0, false);
        solve(root.right, 0, true);

        return max;
    }
}
