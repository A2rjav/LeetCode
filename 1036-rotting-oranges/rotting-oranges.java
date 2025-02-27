class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        
        // add all raw into q
        int fresh = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j< cols;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j,0});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;
        int directions[][] = {{-1,0},{1,0},{0,1},{0,-1}};
        int mins =0;
        while(!q.isEmpty()){
            int curr[] = q.remove();
            int r= curr[0],c=curr[1],t=curr[2];
            mins = Math.max(mins,t);

            for(int[] dir : directions){
                int newRow = dir[0] + r;
                int newCol = dir[1] + c;

                if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && grid[newRow][newCol] == 1){
                    q.add(new int[]{newRow,newCol,t+1});
                    grid[newRow][newCol] = 2;
                    fresh--;    
                }
            }
        }
        return (fresh == 0)?mins:-1;        
    }
}