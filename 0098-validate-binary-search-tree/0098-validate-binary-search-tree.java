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
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        while(root != null) {
            if(root.left == null) {
                if(prev != null && prev.val >= root.val) {
                    return false;
                }
                prev = root;
                root = root.right;
            }
            else {
                TreeNode curr = root.left;
                while(curr.right != null && curr.right != root) {
                    curr = curr.right;
                }
                if(curr.right == null) {
                    curr.right = root;
                    root = root.left;
                }
                else {
                    curr.right = null;
                    if(prev != null && prev.val >= root.val) {
                        return false;
                    }
                    prev = root;
                    root = root.right;
                }
            }
        }
        return true;
    }
}