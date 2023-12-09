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
    int maxValue = 0;
    private Pair<Integer, Integer> postOrder(TreeNode root) {
        if(root == null) {
            return new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        else {
            int max = root.val, min = root.val;
            Pair temp = postOrder(root.left);
            min = Math.min(min, (int)temp.getKey());
            max = Math.max(max, (int)temp.getValue());
            temp = postOrder(root.right);
            min = Math.min(min, (int)temp.getKey());
            max = Math.max(max, (int)temp.getValue());
            maxValue = Math.max(Math.abs(root.val - max), maxValue);
            maxValue = Math.max(Math.abs(root.val - min), maxValue);
            return new Pair<>(min, max);
        }
    }
    public int maxAncestorDiff(TreeNode root) {
        postOrder(root);
        return maxValue;
    }
}