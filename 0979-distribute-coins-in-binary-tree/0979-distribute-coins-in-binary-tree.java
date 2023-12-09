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
    public int distributeDistanceCoins(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = distributeDistanceCoins(root.left); 
        int right = distributeDistanceCoins(root.right);
        max += Math.abs(left) + Math.abs(right);
        return 1 - root.val + left + right;
    }
    public int distributeCoins(TreeNode root) {
        distributeDistanceCoins(root);
        return max;
    }
}