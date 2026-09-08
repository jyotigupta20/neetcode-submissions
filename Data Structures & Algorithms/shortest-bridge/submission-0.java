class Solution {
    private int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean found = false;

        for(int i =0; i<n; i++) {
            if(found) break;
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1){
                   dfs(grid, i, j, queue);
                   found = true;
                   break;
                }
            }
        }
        int step = 0;
        while(!queue.isEmpty()) {
            for(int i=queue.size(); i>0; i--) {
                int[] cell = queue.poll();
                for(int dir[] : direct) {
                    int newRow = dir[0] + cell[0];
                    int newCol = dir[1] + cell[1];
                    if(newRow < 0 || newCol < 0 || newRow >=n || newCol >=n || grid[newRow][newCol] == 2) {
                        continue;
                    }
                    if(grid[newRow][newCol] == 1) {
                        return step;
                    }
                    grid[newRow][newCol] = 2;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
            step++;    
        }

        return -1;
    }

    void dfs(int[][] grid, int row, int col, Queue<int[]> queue) {
        if(row < 0 || col < 0 || row >=grid.length || col >=grid.length || grid[row][col] != 1) {
            return;
        }
        grid[row][col] = 2;
        queue.offer(new int[]{row, col});
        for(int dir[] : direct) {
            int newRow = row+dir[0];
            int newCol = col+dir[1];
            dfs(grid, newRow, newCol, queue);
        }
        
    }
}