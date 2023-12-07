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
    ArrayList<Integer> InOrderTraversal(TreeNode root) {
        ArrayList<Integer> ans  = new ArrayList<Integer>();
        while(root != null) {
            if(root.left == null) {
                ans.add(root.val);
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
                    ans.add(root.val);
                    curr.right = null;
                    root = root.right;
                }
            }
        }

        return ans;
    }

    TreeNode construct(ArrayList<Integer> arr, int start, int end) {
        if(start > end) {
            return null;
        }
        else {
            int mid = (end - start)/2 + start;
            return new TreeNode(arr.get(mid), 
                                construct(arr, start, mid - 1),
                                construct(arr, mid + 1, end)
                                );
        }
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> sortedOrder =  InOrderTraversal(root);
        return construct(sortedOrder, 0, sortedOrder.size() - 1);
    }
}