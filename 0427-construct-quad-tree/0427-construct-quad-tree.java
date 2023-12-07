/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node constructQuadTree(int[][] grid, int x, int y, int len) {
        if(len == 0)
            return null;
        for(int i = x; i < x + len; i++) {
            for(int j = y; j < y + len; j++) {
                if(grid[i][j] != grid[x][y]) {
                    return new Node(grid[x][y] == 1, false,
                        constructQuadTree(grid, x, y, len/2),
                        constructQuadTree(grid, x, y + len/2, len/2),
                        constructQuadTree(grid, x + len/2, y, len/2),
                        constructQuadTree(grid, x + len/2, y + len/2, len/2)
                    );
                }
            }
        }
        return new Node(grid[x][y] == 1, true);
    }
    public Node construct(int[][] grid) {
        return constructQuadTree(grid, 0, 0, grid.length);
    }
}