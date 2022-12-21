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

    public int findTime(TreeNode target, HashMap<TreeNode, TreeNode> parent) {
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(target);
        visited.put(target, true);
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int flag = 0;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null && visited.get(current.left) == null) {
                    flag = 1;
                    visited.put(current.left, true);
                    queue.offer(current.left);
                }

                if (current.right != null && visited.get(current.right) == null) {
                    flag = 1;
                    visited.put(current.right, true);
                    queue.offer(current.right);
                }

                if (parent.get(current) != null && visited.get(parent.get(current)) == null) {
                    flag = 1;
                    visited.put(parent.get(current), true);
                    queue.offer(parent.get(current));
                }
            }
            if (flag == 1) time++;
        }
        return time;
    }

    public TreeNode mapParent(TreeNode root, HashMap<TreeNode, TreeNode> parent, int start) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode result = null;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.val == start) {
                result = current;
            }

            if (current.left != null) {
                parent.put(current.left, current);
                queue.offer(current.left);
            }

            if (current.right != null) {
                parent.put(current.right, current);
                queue.offer(current.right);
            }
        }
        return result;
    }

    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode target = mapParent(root, parent, start);
        int time = findTime(target, parent);
        return time;
    }
}
