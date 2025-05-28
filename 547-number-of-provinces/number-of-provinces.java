class Solution {
    boolean vis[];
    int n;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public int findCircleNum(int[][] isConnected) {
        n= isConnected.length;
        vis = new boolean[n];
        int ans=0;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ans++;
                dfs(adj,i);
            }
        }
        return ans;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int curr){
        vis[curr] = true;
        for(int i : adj.get(curr)){
            if(!vis[i] ) dfs(adj,i);
        }
    }
}