public class Solution {
    public void solveSudoku(char[][] board) {
        
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        
        // Create hashsets for 9 rows, 9 cols, and 3x3 clusters
        ArrayList<HashSet<Character>> setRows = new ArrayList<HashSet<Character>>(9);
        ArrayList<HashSet<Character>> setCols = new ArrayList<HashSet<Character>>(9);
        ArrayList<HashSet<Character>> setClus = new ArrayList<HashSet<Character>>(9);
        
        // Create list of locations to be filled
        ArrayList<ArrayList<Integer>> setLoc = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < 9; i++) {
			setRows.add(new HashSet<Character>());
			setCols.add(new HashSet<Character>());
			setClus.add(new HashSet<Character>());
		}
        
        // Populate hashsets (assuming valid initial configuration)
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                int clustNum = 3*row/3 + col/3 - row % 3;
                if (c != '.') {
                    setRows.get(row).add(c);
                    setCols.get(col).add(c);
                    setClus.get(clustNum).add(c);
                } else {
                    ArrayList<Integer> loc = new ArrayList<Integer>();
                    loc.add(row);
                    loc.add(col);
                    setLoc.add(loc);
                }
            }
        }
        
        // Use helper function
        solveSudokuHelper(board, setLoc, 0, setRows, setCols, setClus);
        
    }
    
    public boolean solveSudokuHelper(char[][] board, ArrayList<ArrayList<Integer>> setLoc, int idx, ArrayList<HashSet<Character>> setRows, ArrayList<HashSet<Character>> setCols, ArrayList<HashSet<Character>> setClus) {
        
        // Base case
        if (idx == setLoc.size()) return true;
        
        ArrayList<Integer> loc = setLoc.get(idx);
        int row = loc.get(0);
        int col = loc.get(1);
        
        int clustNum = 3*row/3 + col/3 - row % 3;
        
        // Check possible values
        for (int n = 1; n <= 9; n++) {
            
            // Create char
            char c = (char) ('0' + n);
            
            // Check is possible
            if (!setRows.get(row).contains(n) && !setCols.get(col).contains(n) && !setClus.get(clustNum).contains(n)) {
                
                // Fill position
                board[row][col] = c;
                
                // Update hashsets
                setRows.get(row).add(c);
                setCols.get(col).add(c);
                setClus.get(clustNum).add(c);
                
                // Fill next position
                if (solveSudokuHelper(board, setLoc, idx+1, setRows, setCols, setClus)) return true;
                
                // Update hashsets
                setRows.get(row).remove(c);
                setCols.get(col).remove(c);
                setClus.get(clustNum).remove(c);
            }
        }
        
        return false;
    }
}