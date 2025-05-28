class Solution {
    class Info{
        int row,col,t;
        public Info(int row,int col,int t){
            this.row = row;
            this.col = col;
            this.t = t;
        }
    }
    int m,n;
    // boolean vis[][];
    int ans =0;
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int cnt =0;
        Queue<Info> q = new LinkedList<>();
        // vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2 ){
                    q.add(new Info(i,j,0));
                    // vis[i][j] = true;
                } 
                else if(grid[i][j] == 1) cnt++;
            }
        }

        if(cnt == 0 ) return 0;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while(!q.isEmpty()){
            int r= q.peek().row;
            int c= q.peek().col;
            int tm = q.peek().t;
            q.poll();
            ans = Math.max(ans,tm);
            for(int i=0;i<4;i++){
                int nrow = r + dr[i];
                int ncol = c + dc[i];

                if(nrow>=0 && nrow<m && ncol >=0 && ncol<n && grid[nrow][ncol] == 1) {
                    q.add(new Info(nrow,ncol,tm+1));
                    grid[nrow][ncol] = 2;
                    cnt--;
                }
            }
        }
        return cnt==0? ans:-1;
    }
}