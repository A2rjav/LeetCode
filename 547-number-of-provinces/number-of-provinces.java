class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length,ans=0;
        boolean [] vis = new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                ans++;
                dfs(isConnected,vis,i);
            }
        }
        return ans;
    }
    public void dfs(int[][] isConnected,boolean[] vis,int i){
        vis[i] = true;

        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j] == 1 && !vis[j]){
                dfs(isConnected,vis,j);
            }
        }
    }
}