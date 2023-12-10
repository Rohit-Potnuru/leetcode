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
    int maxPathSum = Integer.MIN_VALUE;
    public int helper(TreeNode root) {
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        
        int ans = Math.max(left, right) + root.val;
        ans = Math.max(ans, root.val);

        maxPathSum = Math.max(maxPathSum, left + right + root.val);
        maxPathSum = Math.max(maxPathSum, ans);
        return ans;
    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxPathSum;
    }
}