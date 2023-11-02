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
    int ans = 0;
    public int[] DFS(TreeNode root) {
        if(root == null) return new int[]{0, 0};
        int[] left = DFS(root.left);
        int[] right = DFS(root.right);  
        int sum = left[0] + right[0] + root.val;
        int n = left[1] + right[1] + 1;
        if(sum/n == root.val)
            ans += 1;
        return new int[]{sum, n};
    }
    public int averageOfSubtree(TreeNode root) {
        DFS(root);
        return ans;
    }
}