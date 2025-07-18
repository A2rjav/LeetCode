class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());

        for(int []connection: connections){
            int u = connection[0];
            int v = connection[1];
            adj.get(u).add(new int[]{v,1});
            adj.get(v).add(new int[]{u,0});
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean vis[] = new boolean[n];

        return dfs(0,adj,vis);
    }
    public int dfs(int u,ArrayList<ArrayList<int[]>> adj,boolean[]vis){
        vis[u] = true;
        int changes = 0;

        for(int neighbor[]:adj.get(u)){
            int v = neighbor[0];
            int cost = neighbor[1];

            if(!vis[v]){
                changes += cost;
                changes += dfs(v,adj,vis);
            }
        }
        return changes;
    }
}