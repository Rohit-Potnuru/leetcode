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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        int val = low <= root.val && root.val <= high ? root.val : 0;
        if(low < root.val) {
            val += rangeSumBST(root.left, low, high);
        }
        if(root.val < high) {
            val += rangeSumBST(root.right, low, high);
        }
        return val;
    }
}