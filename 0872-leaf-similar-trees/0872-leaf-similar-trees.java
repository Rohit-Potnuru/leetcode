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
    List<Integer> temp;
    public void leafNode(TreeNode root) {
        if(root.left == null && root.right == null) {
            temp.add(root.val);
        }
        if(root.left != null) {
            leafNode(root.left);
        }
        if(root.right != null) {
            leafNode(root.right);
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> curr1 = new ArrayList<Integer>();
        temp = curr1;
        leafNode(root1);
        List<Integer> curr2 = new ArrayList<Integer>();
        temp = curr2;
        leafNode(root2);
        if(curr1.size() != curr2.size()) {
            return false;
        }
        for(int i = 0; i < curr1.size(); i++) {
            if(curr1.get(i) != curr2.get(i))
                return false;
        }
        return true;
    }
}