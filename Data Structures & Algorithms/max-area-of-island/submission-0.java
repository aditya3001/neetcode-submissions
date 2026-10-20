class Solution {
    int area = 0;

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                   area = Math.max(explore(grid, i, j, visited), area);

                }
            }
        }
        return area;
    }

    public int explore(int[][] grid, int row, int col, boolean[][] visited) {

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
            return 0;
        }
        int sum = 1;
        visited[row][col] = true;
        sum+= explore(grid, row+1, col, visited);
        sum+= explore(grid, row-1, col, visited);
        sum+= explore(grid, row, col+1, visited);
        sum+= explore(grid, row, col-1, visited);
        // System.out.println(sum);
        return sum;

    }
}
