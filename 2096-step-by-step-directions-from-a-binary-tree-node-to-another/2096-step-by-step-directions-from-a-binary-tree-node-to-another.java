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
    public TreeNode LowestCommonAncestor(TreeNode root, int start, int end) {
        if (root == null) {
            return null;
        }

        if (root.val == start || root.val == end) {
            return root;
        }

        TreeNode leftAns = LowestCommonAncestor(root.left, start, end);
        TreeNode rightAns = LowestCommonAncestor(root.right, start, end);

        if (leftAns != null && rightAns != null) {
            return root;
        }

        if (leftAns == null) return rightAns; else if (rightAns == null) return leftAns; else return null;
    }

    public boolean buildPath(TreeNode root, int target, StringBuilder sb) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        sb.append('L');

        boolean left = buildPath(root.left, target, sb);

        if (left == true) {
            return true;
        }

        sb.delete(sb.length() - 1, sb.length());

        sb.append('R');

        boolean right = buildPath(root.right, target, sb);

        if (right == true) {
            return true;
        }

        sb.delete(sb.length() - 1, sb.length());
        
        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ancestor = LowestCommonAncestor(root, startValue, destValue);
        StringBuilder sb = new StringBuilder();
        
        buildPath(ancestor, startValue, sb);
        
        int len = sb.length();
        String path1 = "";
        
        for(int i=0; i<len; i++){
            path1 += "U";
        }
        
        sb.setLength(0);
        buildPath(ancestor, destValue, sb);
        
        String path2 = sb.toString();
        
        return path1 + path2;
    }
}


