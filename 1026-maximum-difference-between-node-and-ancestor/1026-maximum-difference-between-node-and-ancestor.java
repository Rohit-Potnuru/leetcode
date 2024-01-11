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
        int[] temp = new int[2], temp1, temp2;
        temp[0] = Integer.MAX_VALUE;
        temp[1] = Integer.MIN_VALUE;
        if(root.left != null) {
            temp = dfs(root.left);
            this.maxDiff = Math.max(Math.abs(temp[0] - root.val), this.maxDiff);
            this.maxDiff = Math.max(Math.abs(temp[1] - root.val), this.maxDiff);
        }
        if(root.right != null) {
            temp1 = dfs(root.right);
            temp[0] = Math.min(temp[0], temp1[0]);
            temp[1] = Math.max(temp[1], temp1[1]);
            this.maxDiff = Math.max(Math.abs(temp[0] - root.val), this.maxDiff);
            this.maxDiff = Math.max(Math.abs(temp[1] - root.val), this.maxDiff);
        }
        temp[0] = Math.min(temp[0], root.val);
        temp[1] = Math.max(temp[1], root.val);
        return temp;
    }
    public int maxAncestorDiff(TreeNode root) {
        this.maxDiff = 0;
        if(root != null) {
            dfs(root);
        }
        return maxDiff;
    }
}