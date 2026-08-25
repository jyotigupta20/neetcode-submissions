class Solution {

    private final int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return;
        }
       Queue<int[]> queue = new ArrayDeque();
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == 0) {
                   queue.offer(new int[]{i,j}); 
                }
            }
        }

        int[][] dir = {{0,-1}, {0,1}, {-1,0}, {1,0}};
        while(!queue.isEmpty()){
          int[] corr = queue.poll();
          int newRow = corr[0];
          int newCol = corr[1];

          for(int[] next: dir) {
            int nextRow = newRow + next[0];
            int nextCol = newCol + next[1];
            if(nextRow<0 
            || nextCol<0 
            || nextRow>=row 
            || nextCol>=col 
            || grid[nextRow][nextCol]!= INF) {
                continue;
            }
            grid[nextRow][nextCol] = grid[newRow][newCol] + 1;
            queue.offer(new int[]{nextRow,nextCol});
          }
        }
    }
}
