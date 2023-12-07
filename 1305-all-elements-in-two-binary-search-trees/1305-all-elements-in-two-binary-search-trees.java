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
    public TreeNode Traverse(TreeNode root) {
        while(root != null) {
            if(root.left == null) {
                return root;
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
                    return root;
                }
            }
        }
        return null;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> ans = new ArrayList<>();
        root1 = Traverse(root1);
        root2 = Traverse(root2);
        while(root1 != null || root2 != null) {
            if(root1 == null || (root2 != null && (root1.val > root2.val))) {
                ans.add(root2.val);
                root2 = Traverse(root2.right);
            }
            else {
                ans.add(root1.val);
                root1 = Traverse(root1.right);
            }
        }
        return ans;   
    }
}