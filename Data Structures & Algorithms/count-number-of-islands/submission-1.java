class Solution {
    int count = 0;
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    explore(grid, i, j, visited);

                }
            }
        }
        return count;
    }

    public void explore(char[][] grid, int row, int col, boolean[][] visited) {

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == '0') {
            return;
        }

        visited[row][col] = true;
        explore(grid, row+1, col, visited);
        explore(grid, row-1, col, visited);
        explore(grid, row, col+1, visited);
        explore(grid, row, col-1, visited);

    }
}
