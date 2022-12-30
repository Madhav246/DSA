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
    int maxCount;

    public void solve(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        solve(root.left, map);

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        maxCount = Math.max(maxCount, map.get(root.val));

        solve(root.right, map);
    }

    public int[] findMode(TreeNode root) {
        maxCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        solve(root, map);

        int[] result = new int[map.size()];
        int index = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == maxCount) {
                result[index++] = key;
            }
        }

        return Arrays.copyOf(result, index);
    }
}
