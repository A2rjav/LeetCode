class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean isConnected[][]= new boolean[n][n];
        int indeg[] = new int[n];
        for(int road[] : roads){
            int u = road[0];
            int v = road[1];
            indeg[u]++;
            indeg[v]++;
            isConnected[u][v] = true;
            isConnected[v][u] = true;
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum = indeg[i]+indeg[j];
                if(isConnected[i][j]) sum--;
                ans = Math.max(ans,sum);
            }
        }
        return ans;
    }
}