class Solution {
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> squareMap = new HashMap<>();

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                char val = board[row][col];
                if(val == '.') continue;
                if (colMap.computeIfAbsent(col, v -> new HashSet<>()).contains(val)) {
                    return false;
                } else {
                    colMap.get(col).add(val);
                }
                if (rowMap.computeIfAbsent(row, v -> new HashSet<>()).contains(val)) {
                    return false;
                } else {
                    rowMap.get(row).add(val);
                }

                int squareNumber = (row/3)*3+(col/3);
                if (squareMap.computeIfAbsent(squareNumber, v -> new HashSet<>()).contains(val)) {
                    return false;
                } else {
                    squareMap.get(squareNumber).add(val);
                }

            }
        }
        return true;
        
    }
}
