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
class BSTIterator {
    TreeNode root;
    public BSTIterator(TreeNode root) {
       this.root = root; 
    }
    
    public int next() {
        while(this.root != null) {
            if(this.root.left == null) {
                int val = this.root.val;
                this.root = this.root.right;
                return val;
            }
            else {
                TreeNode curr = this.root.left;
                while(curr.right != null && curr.right != root) {
                    curr = curr.right;
                }

                if(curr.right == null) {
                    curr.right = this.root;
                    this.root = this.root.left;
                }
                else {
                    curr.right = null;
                    int val = this.root.val;
                    this.root = this.root.right;
                    return val;
                }
            }
        }
        return 0;
    }
    
    public boolean hasNext() {
        return root != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */