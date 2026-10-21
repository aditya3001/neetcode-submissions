class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0 ; i < rows; i++) {
            for (int j = 0; j< cols; j++) {
                if(grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] cell = q.remove();
            int r = cell[0];
            int c = cell[1];

            for(int[] dir : directions) {
                int cr = r + dir[0];
                int cc = c + dir[1];
                if (cr < 0 || cc < 0 || cr >= rows || cc >= cols || grid[cr][cc] != Integer.MAX_VALUE) continue;
                grid[cr][cc] = grid[r][c]+1;
                q.add(new int[]{cr, cc});
            }
        }
        
    }
}
