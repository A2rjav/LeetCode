class Solution {
    int m,n;
    boolean [][]vis;
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        vis = new boolean[m][n];
        int dist[][] = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                    vis[i][j] = true;
                }
                
            }
        }

        int dirs[][]= {{-1,0},{1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int curr[] = q.poll();
            for(int []dir: dirs){
                int newR = dir[0] + curr[0];
                int newC = dir[1] + curr[1];

                if(newR>=0 && newR <m && newC>=0 && newC < n && !vis[newR][newC]){
                    dist[newR][newC] = dist[curr[0]][curr[1]] +1;
                    q.add(new int[]{newR,newC});
                    vis[newR][newC] = true;
                } 
            }
        }
        return dist;
    }
}