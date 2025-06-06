class Solution {
    public int findTheCity(int n, int[][] edges, int matanceThreshold) {
        int mat[][] = new int[n][n];
        int inf = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = Integer.MAX_VALUE;
                if(i == j) mat[i][j] = 0;
            }
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            mat[u][v] = wt;
            mat[v][u] = wt;

        }
        

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][k] != inf && mat[k][j] != inf){
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }
        }

        int minReachable = n;
        int ans = -1;

        for(int i=0;i<n;i++){
            int reachable = 0;
            for(int j=0;j<n;j++){
                if(i!=j && mat[i][j] <= matanceThreshold) reachable++;
            }
            if(reachable<=minReachable){
                minReachable = reachable;
                ans = i;
            }
        }

        return ans;

    }
}