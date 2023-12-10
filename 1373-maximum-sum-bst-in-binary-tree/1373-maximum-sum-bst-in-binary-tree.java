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
    int maxSum = 0;
    private int[] sumBST(TreeNode root) {
        int[] left = null, right = null;
        int[] ans = new int[]{root.val, root.val, root.val, 1};
        if(root.left != null) {
            left = sumBST(root.left);
            ans[0] = Math.min(ans[0], left[0]);
            ans[1] = Math.max(ans[1], left[1]);
            ans[2] += left[2];
            if(left[1] >= root.val || left[3] == 0) {
                ans[3] = 0;
            }
        }
        if(root.right != null) {
            right = sumBST(root.right);
            ans[0] = Math.min(ans[0], right[0]);
            ans[1] = Math.max(ans[1], right[1]);
            ans[2] += right[2];
            if(right[0] <= root.val || right[3] == 0) {
                ans[3] = 0;
            }
        }
        if(ans[3] == 1) {
            maxSum = Math.max(maxSum, ans[2]);
        }
        return ans;
    }
    public int maxSumBST(TreeNode root) {
        sumBST(root);
        return maxSum;
    }
}