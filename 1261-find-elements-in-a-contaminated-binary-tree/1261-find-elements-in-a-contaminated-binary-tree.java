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
class FindElements {
    TreeNode root;
    private void Recover(TreeNode root) {
        if(root.left != null) {
            root.left.val = 2 * root.val + 1;
            Recover(root.left);
        }
        if(root.right != null) {
            root.right.val = 2 * root.val + 2;
            Recover(root.right);
        }
    }

    public FindElements(TreeNode root) {
        root.val = 0;
        Recover(root);
        this.root = root;
    }
    
    private boolean find(TreeNode root, int target) {
        if(root == null)
            return false;
        if(root.val == target)
            return true;
        return find(root.left, target) || find(root.right, target);
    }

    public boolean find(int target) {
        return find(this.root, target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */