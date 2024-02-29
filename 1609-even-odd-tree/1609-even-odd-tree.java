class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        int level = 0, prev;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            prev = (level % 2 == 0) ? 0: Integer.MAX_VALUE;
            while(size > 0) {
                root = q.poll();
                if(level%2 == 0 && !(root.val%2 == 1 && prev < root.val)) return false;
                if(level%2 == 1 && !(root.val%2 == 0 && prev > root.val)) return false;
                prev = root.val;
                if(root.left != null) {
                    q.offer(root.left);
                }
                if(root.right != null) {
                    q.offer(root.right);
                }
                size--;
            }
            level++;
        }
        return true;
    }
}