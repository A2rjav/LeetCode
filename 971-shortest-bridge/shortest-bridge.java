class Solution {
    int n;
    Queue<int[]> q = new LinkedList<>();
    
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        
        boolean found = false;
        for(int i=0;i<n;i++){
            if(found) break;
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    found = true;
                    dfs(grid,i,j);
                    break;
                }
                
            }
        }

        int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        int steps= 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int curr[] = q.poll();
                int r =  curr[0];
                int c = curr[1];

                for(int dir[]:dirs){
                    int newR = dir[0] +r;
                    int newC = dir[1] + c;

                    if(newR>=0 && newC >=0 && newR < n && newC<n){
                        if(grid[newR][newC] == 1)
                        return steps;
                        if(grid[newR][newC] == 0){
                            grid[newR][newC] = 2;
                            q.add(new int[]{newR,newC,steps+1});
                        }
                    }
                }
            }
            steps++;
            
        }
        return 0;
    }

    void dfs(int[][] grid, int i,int j){

        if(i<0 || i>= n|| j<0 || j>= n || grid[i][j] != 1)
        return;

        q.add(new int[]{i,j});
        grid[i][j] = 2;

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}