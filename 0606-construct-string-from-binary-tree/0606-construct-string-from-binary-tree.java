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
    public String tree2str(TreeNode root) {
        if(root == null) return "";
        StringBuilder strB = new StringBuilder();
        strB.append(root.val);

        if(root.left != null || root.right != null) {
            strB.append("(");
            strB.append(tree2str(root.left));
            strB.append(")");
        }

        if(root.right != null) {
            strB.append("(");
            strB.append(tree2str(root.right));
            strB.append(")");
        }
        return strB.toString();
    }
}