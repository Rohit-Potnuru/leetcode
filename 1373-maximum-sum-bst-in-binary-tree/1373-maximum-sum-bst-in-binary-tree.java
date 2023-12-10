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
    static class NodeWrapper {
        int sum;
        int max;
        int min;
        boolean validBST = true;
        public NodeWrapper(TreeNode node) {
            this.sum = node.val;
            this.max = node.val;
            this.min = node.val;
            this.validBST = true;
        }
    }

    int maxSum = 0;
    private NodeWrapper sumBST(TreeNode root) {
        NodeWrapper temp = null;
        NodeWrapper ans = new NodeWrapper(root);
        if(root.left != null) {
            temp = sumBST(root.left);
            ans.min = Math.min(ans.min, temp.min);
            ans.max = Math.max(ans.max, temp.max);
            ans.sum += temp.sum;
            ans.validBST = ans.validBST && temp.validBST && temp.max < root.val;
        }
        if(root.right != null) {
            temp = sumBST(root.right);
            ans.min = Math.min(ans.min, temp.min);
            ans.max = Math.max(ans.max, temp.max);
            ans.sum += temp.sum;
            ans.validBST = ans.validBST && temp.validBST && root.val < temp.min;
        }
        System.out.println(root.val + " " + ans.validBST);
        if(ans.validBST) {
            maxSum = Math.max(maxSum, ans.sum);
        }
        return ans;
    }
    public int maxSumBST(TreeNode root) {
        sumBST(root);
        return maxSum;
    }
}