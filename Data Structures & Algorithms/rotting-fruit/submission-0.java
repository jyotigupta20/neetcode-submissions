class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length== 0) {
            return -1;
        }

        Queue<int[]> queue = new ArrayDeque();
        int ROW = grid.length;
        int COL = grid[0].length;
        int fresh = 0;
        for(int i=0; i<ROW; i++) {
            for(int j=0; j<COL; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                }
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int time =0;
        while(fresh > 0 && !queue.isEmpty()) {
            int length = queue.size();
            for(int i=0; i<length; i++) {
                int[] curr = queue.poll();
                int currRow = curr[0];
                int currCol = curr[1];

                for(int[] dir : directions) {
                    int newRow = currRow + dir[0];
                    int newCol = currCol + dir[1];

                    if(newRow >= 0 
                    && newCol >= 0 
                    && newRow < ROW 
                    && newCol < COL
                    && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2;
                    fresh--;
                    queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
           time++; 
        }
        if(fresh > 0) {
            return -1;
        } else {
            return time;
        }
    }
}
