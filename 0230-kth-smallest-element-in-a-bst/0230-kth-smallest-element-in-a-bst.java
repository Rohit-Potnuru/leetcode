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
    public int kthSmallest(TreeNode root, int k) {
        int count = 0; 
        while(root != null) {
            if(root.left == null) {
                if(++count == k)
                    return root.val;
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
                    if(++count == k)
                        return root.val;
                    root = root.right;
                }
            }
        }
        return -1;
    }
}