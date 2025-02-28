class Solution {
    int r,c;
    int [][]vis;
    int [][]directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numEnclaves(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        vis = new int[r][c];

        return bfs(grid);
    }
    public int bfs(int [][]grid){
        Queue<int[]> q= new LinkedList<>();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if((i==0 || i==r-1 || j==0 || j==c-1) && grid[i][j] == 1){
                    q.add(new int[]{i,j});
                    vis[i][j] = 1;
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.remove();
            int row = curr[0];
            int col = curr[1];
            for( int[]dir : directions){
            int newRow = dir[0]+row;
            int newCol = dir[1] + col;

            if(newRow>=0 && newCol >= 0 && newRow <r && newCol<c && vis[newRow][newCol] ==0 && grid[newRow][newCol] == 1){
                q.add(new int[]{newRow,newCol});
                vis[newRow][newCol] = 1;
            }
        }
        }
        
        

        int cnt = 0;
        for(int i = 0;i<r;i++) {
            for(int j = 0;j<c;j++) {
                if(grid[i][j] == 1 & vis[i][j] == 0) 
                    cnt++; 
            }
        }
        return cnt;
    }
}