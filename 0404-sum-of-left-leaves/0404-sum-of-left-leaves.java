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
    int sum;

    public void solve(TreeNode root, int direction) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (direction == 0) {
                sum += root.val;
            }
        }

        solve(root.left, 0);
        solve(root.right, 1);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        solve(root, -1);
        return sum;
    }
}
