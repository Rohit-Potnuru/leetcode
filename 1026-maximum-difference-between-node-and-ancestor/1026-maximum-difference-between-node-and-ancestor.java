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
    int maxDiff;
    public int[] dfs(TreeNode root) {
        int[] temp;
        int minVal = root.val, maxVal = root.val;

        if(root.left != null) {
            temp = dfs(root.left);
            minVal = Math.min(minVal, temp[0]);
            maxVal = Math.max(maxVal, temp[1]);
        }
        if(root.right != null) {
            temp = dfs(root.right);
            minVal = Math.min(minVal, temp[0]);
            maxVal = Math.max(maxVal, temp[1]);
        }
        this.maxDiff = Math.max(Math.abs(minVal - root.val), this.maxDiff);
        this.maxDiff = Math.max(Math.abs(maxVal- root.val), this.maxDiff);
        return new int[]{minVal, maxVal};
    }
    public int maxAncestorDiff(TreeNode root) {
        this.maxDiff = 0;
        if(root != null) {
            dfs(root);
        }
        return maxDiff;
    }
}