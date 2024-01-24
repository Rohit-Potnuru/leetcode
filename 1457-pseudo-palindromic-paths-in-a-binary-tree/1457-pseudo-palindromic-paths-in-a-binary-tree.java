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
    int[] freq = new int[10];
    
    public int pseudoPalindromicPaths (TreeNode root) {
    if(root == null)
        return 0;
    if(root.left == null && root.right == null) {
        int odd_count = 0;
        freq[root.val] += 1;
        for(int i = 0; i < freq.length; i++) {
            odd_count += freq[i]%2;
            if(odd_count > 1) {
                freq[root.val] -= 1;
                return 0;
            }
        }
        freq[root.val] -= 1;
        return 1;
    }

        int count = 0;
        freq[root.val] += 1;
        if(root.left != null) {
            count += pseudoPalindromicPaths(root.left);
        }
        if(root.right != null) {
            count += pseudoPalindromicPaths(root.right);
        }
        freq[root.val] -= 1;
        return count;
    }
}