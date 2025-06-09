class Solution {
    class Info{
        int r,c,t;
        Info(int r,int c,int t){
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Info> pq = new PriorityQueue<>((a,b) -> a.t-b.t);
        pq.add(new Info(0,0,grid[0][0]));

        int dirs[][] = {{-1,0},{1,0},{0,1},{0,-1}};
        boolean vis[][] = new boolean[n][n];

        while(!pq.isEmpty()){
            Info curr= pq.poll();
            int r = curr.r;
            int c = curr.c;
            int t = curr.t;

            if(vis[r][c]) continue;
            vis[r][c] = true;
            if(r == n-1 && c==n-1) return t;

            for(int dir[] : dirs){
                int nr = dir[0] + r;
                int nc = dir[1] + c;

                if(nr>=0 && nc>=0 && nr<n && nc<n && !vis[nr][nc]){
                    int newT = Math.max(t,grid[nr][nc]);
                    pq.add(new Info(nr,nc,newT));
                }
            } 
        }
        return -1;
        
    }
}