class Solution {
    boolean vis[] ;
    int n;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        int ans= 0;
        vis = new boolean[n];
        for(int i =0;i<n;i++){
            if(!vis[i]){
                ans++;
                dfs(isConnected,i);
            }
        }
        return ans;
    }

    public void dfs(int[][] isConnected, int curr){
        vis[curr] = true;
        for(int i =0;i<n;i++){
            if(isConnected[curr][i] == 1 && !vis[i]) dfs(isConnected,i);
        }
    }
}