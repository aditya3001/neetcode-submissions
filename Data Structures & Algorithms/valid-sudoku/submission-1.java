class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Map<Integer, Set<Character>> rowMatrix = new HashMap<>();
        Map<Integer, Set<Character>> colMatrix = new HashMap<>();
        Map<Integer, Set<Character>> blockMatrix = new HashMap<>();

        for(int i = 0; i< 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if(!rowMatrix.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j])) {
                        rowMatrix.get(i).add(board[i][j]);
                    } else {
                        return false;
                    }
                    if(!colMatrix.computeIfAbsent(j, k -> new HashSet<>()).contains(board[i][j])) {
                        colMatrix.get(j).add(board[i][j]);
                    } else {
                        return false;
                    }
                    int blockNum = 3*(i / 3) + (j/3);
                    if(!blockMatrix.computeIfAbsent(blockNum, k -> new HashSet<>()).contains(board[i][j])) {
                        blockMatrix.get(blockNum).add(board[i][j]);
                    } else {
                        return false;
                    }
                }
                

            }
        }
        return true;
    }
}
