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
    int max;
    public int dfs(TreeNode root, int start) {
        if(root == null) {
            return 0;
        }
        if(root.val == start) {
            this.max = Math.max(dfs(root.left, start), dfs(root.right, start));
            return -1;
        }
        int left = dfs(root.left, start);
        int right = dfs(root.right, start);
        if(left < 0 || right < 0) {
            this.max = Math.max(this.max, Math.abs(left) + Math.abs(right));
            return Math.min(left, right) - 1;
        }
        return Math.max(left, right) + 1;
    }
    public int amountOfTime(TreeNode root, int start) {
        this.max = 0;
        dfs(root, start);
        return this.max;
    }
}