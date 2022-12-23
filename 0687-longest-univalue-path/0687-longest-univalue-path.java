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

    public int solve(TreeNode root, int[] maxi) {
        if (root == null) {
            return 0;
        }

        int left = solve(root.left, maxi);
        int right = solve(root.right, maxi);

        int leftDepth = 0;
        int rightDepth = 0;

        if (root.left != null) {
            if (root.val == root.left.val) {
                leftDepth += left + 1;
            }
        }

        if (root.right != null) {
            if (root.val == root.right.val) {
                rightDepth += right + 1;
            }
        }

        maxi[0] = Math.max(maxi[0], leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth);
    }

    public int longestUnivaluePath(TreeNode root) {
        int[] maxi = new int[1];
        solve(root, maxi);
        return maxi[0];
    }
}
