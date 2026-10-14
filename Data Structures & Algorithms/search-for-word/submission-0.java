class Solution {
    int[][] positions = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean result = false;

        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    result = search(board, i, j, visited, word, 1);
                    if (result) return true;
                    visited[i][j] = false;

                }
            }
        }
        return false;
        
    }

    public boolean search(char[][] board, int x, int y, boolean[][] visited, String word, int indexToBeMatched) {

        if(indexToBeMatched >= word.length()){
            return true;
        }
        boolean exist = false;

        for(int[] position : positions) {
            int currentX = x+position[0];
            int currentY = y+position[1];

            // System.out.println("Here "+indexToBeMatched + " " + currentX + " "+ currentY);
            if (currentX>=0 && currentX < board.length && currentY>=0 && currentY < board[0].length && board[currentX][currentY] == word.charAt(indexToBeMatched) && !visited[currentX][currentY]) {
                // System.out.println( currentX + " "+ currentY);
                visited[currentX][currentY] = true;
                exist = search(board, currentX, currentY, visited, word, indexToBeMatched+1);
                if (exist) return true;
                visited[currentX][currentY] = false;
            }
        }

        return false;


    }
}
