class Solution {
    final int[][] direction = {{0,-1}, {0, 1}, {-1,0},{1,0}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        
        for(int i = 0; i< row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void bfs(char[][] grid, int currRow, int currCol) {
        Queue<int[]> queue = new LinkedList();
        grid[currRow][currCol] = '0';
        queue.offer(new int[]{currRow, currCol});

        while(!queue.isEmpty()){
            int[] currNode = queue.poll();
            int row = currNode[0];
            int col = currNode[1];
            for(int[] corr: direction) {
                int newRow = corr[0] + row;
                int newCol = corr[1] + col;
                if(newRow >= 0 && newCol >= 0 
                && newRow < grid.length 
                && newCol < grid[0].length
                && grid[newRow][newCol] == '1'){
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0';
                } 
            }
        }
    }
}
