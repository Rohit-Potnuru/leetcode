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
    public Pair<Integer, TreeNode> getLcaDeepestLeaves(TreeNode root) {
        if(root == null) {
            return new Pair<>(0, null);
        }
        Pair<Integer, TreeNode> left = getLcaDeepestLeaves(root.left);
        Pair<Integer, TreeNode> right = getLcaDeepestLeaves(root.right);
        if(left.getKey() == right.getKey()) {
            return new Pair<>(left.getKey() + 1, root);
        }
        else if(left.getKey() < right.getKey()) {
            return new Pair<>(right.getKey() + 1, right.getValue());
        }
        else {
            return new Pair<>(left.getKey() + 1, left.getValue());
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair<Integer, TreeNode> res = getLcaDeepestLeaves(root);
        return res.getValue();
    }
}