class Solution {
    public boolean dfs(char[][] board, String word, int wordPos, int posx, int posy) {
        if(wordPos == word.length() - 1) return board[posx][posy] == word.charAt(wordPos);
        if(board[posx][posy] != word.charAt(wordPos)) return false;
        int m = board.length, n = board[0].length;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        char temp = board[posx][posy];
        board[posx][posy] = '.';
        for(int[] neighbor : directions) {
            int dx = posx + neighbor[0];
            int dy = posy + neighbor[1];

            if(0 <= dx && dx < m && 0 <= dy && dy < n) {
                if(dfs(board, word, wordPos + 1, dx, dy)) {
                    return true;
                }
            }
        }
        board[posx][posy] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
}