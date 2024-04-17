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
    String ans = null;
    public void updateSmallestString(String currString) {
        if(ans == null || currString.compareTo(ans) < 0) {
            ans = currString;
        }
    }
    public void dfs(TreeNode root, StringBuilder sb) {
        sb.insert(0, (char) ('a' + root.val));
        if(root.left == null && root.right == null) {
            updateSmallestString(sb.toString());
        }
        if(root.left != null) {
            dfs(root.left, sb);
        }
        if(root.right != null) {
            dfs(root.right, sb);
        }
        sb.deleteCharAt(0);
    }
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }
}