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
    long max = 0, totalSum = 0, sum;

    long totalSumTree(TreeNode root) {
        if(root == null) return 0;
        sum = root.val + totalSumTree(root.left) + totalSumTree(root.right);
        max = Math.max(max, (sum * (totalSum - sum)));
        return sum;
    }
    public int maxProduct(TreeNode root) {
        totalSum = totalSumTree(root);
        totalSumTree(root);
        return (int)(max%(int)(1e9 + 7));
    }

}