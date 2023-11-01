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
    public int[] findMode(TreeNode root) {

        ArrayList<Integer> mode = new ArrayList<>();
        int prev = Integer.MAX_VALUE, count = 0, maxCount = 0;

        TreeNode curr = root, temp;
        while(curr != null) {
            //find rightmost
            if(curr.left == null) {
                if(prev != curr.val) {
                    count = 0;
                    prev = curr.val;
                }
                count++;
                if(maxCount <= count) {
                    if(maxCount != count)
                        mode.clear();
                    maxCount = count;
                    mode.add(curr.val);
                }
                curr = curr.right;
            }
            else {
                temp = curr.left;
                while(temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }

                if(temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                }
                else {
                    if(prev != curr.val) {
                        count = 0;
                        prev = curr.val;
                    }
                    count++;
                    if(maxCount <= count) {
                        if(maxCount != count)
                            mode.clear();
                        maxCount = count;
                        mode.add(curr.val);
                    }

                    temp.right = null;
                    curr = curr.right;
                }
            }
        }
        return mode.stream().mapToInt(i -> i).toArray();
    }
}