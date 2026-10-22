class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i< rows; i++) {
            for(int j = 0; j < cols ; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int minute = 0;

        while(!q.isEmpty()) {
            Queue<int[]> currentLevel = new LinkedList<>();
            while (!q.isEmpty()) {
                int[] current = q.poll();
                int r = current[0];
                int c = current[1];

                for(int[] dir : directions) {
                    int cr = r+dir[0];
                    int cc = c+dir[1];

                    if(cr >= 0 && cr < rows && cc >= 0 && cc < cols && grid[cr][cc] == 1) {
                        grid[cr][cc] = 2;
                        // System.out.println(cr+" "+cc+ " "+ minute);
                        currentLevel.add(new int[]{cr, cc});
                    }

                } 
                

            }
            
            if (!currentLevel.isEmpty()) minute++;
            while (!currentLevel.isEmpty()) {
                q.add(currentLevel.poll());
            }
            
        }

        for(int i = 0; i< rows; i++) {
            for(int j = 0; j < cols ; j++) {
                // System.out.println(i+" "+j);
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minute;
        
    }
}
