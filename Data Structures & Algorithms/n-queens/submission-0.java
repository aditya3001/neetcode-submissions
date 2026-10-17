class Solution {

    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

        int[][] board = new int[n][n];
        boolean[] cols = new boolean[n];
        boolean[] leftDiagonal = new boolean[2*n];
        boolean[] rightDiagonal = new boolean[2*n];
        queen(board, cols, leftDiagonal, rightDiagonal, 0);
        return ans;


        
    }

    public void queen(int[][] board, boolean[] cols, boolean[] leftDiagonal, boolean[] rightDiagonal, int row) {
        if (row == board.length) {
            ans.add(getAnsString(board));
            return;
        }

        for(int i = 0; i < board[0].length; i++) {
            if (cols[i] || leftDiagonal[row+i] || rightDiagonal[row - i+ board.length - 1]) {
                continue;
            }

            cols[i] = true;
            leftDiagonal[row+i] = true;
            rightDiagonal[row - i+ board.length - 1] = true;
            board[row][i] = 1;
            queen(board, cols, leftDiagonal, rightDiagonal, row+1);
            cols[i] = false;
            leftDiagonal[row+i] = false;
            rightDiagonal[row - i+ board.length - 1] = false;
            board[row][i] = 0;

        }

    }

    public List<String> getAnsString(int[][] board) {
        List<String> str = new ArrayList<>();

        for(int i = 0; i < board.length ; i++) {
            StringBuilder res = new StringBuilder();
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    res.append("Q");
                }else {
                    res.append(".");
                }
            }
            str.add(res.toString());
        }
        return str;

    }


    // public boolean check(boolean[] col, boolean[] row, int x, int y) {

    //     if (row[x] || col[y]) return false;
    //     for(int i = x-1, j = y-1; i >= 0, j >= 0; i--,j--) {       
    //         if (x-i >= 0 && y - j >= 0) {
    //             return !(row[x-i] && col[y-j]);
    //         }
    //     }

    //     for(int i = x-1, j = y+1; i >= 0, j < col.length; i--,j++) {       
    //         if (x-i >= 0 && y + j < col.length) {
    //             return !(row[x-i] && col[y + j]);
    //         }
    //     }

    //     return true;

    // }
}
