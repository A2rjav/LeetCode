class Solution {
    class Pair{
        int node;
        int col;
        Pair(int node,int col){
            this.node = node;
            this.col = col;
        }
    }
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(int []edge : redEdges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(new Pair(v,1));
        }
        for(int []edge : blueEdges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(new Pair(v,2));
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        int ans[] = new int[n];
        Arrays.fill(ans,-1);
        ans[0] = 0;

        boolean vis[][]= new boolean[n][3];
        vis[0][0] = true;
        
        int dist=0;
        while(!q.isEmpty()){
            int size = q.size();
          

            for(int i=0;i<size;i++){
                Pair curr = q.poll();
                int node = curr.node;
                int col = curr.col;

                for(Pair neighbor : adj.get(node)){
                    int neighborNode = neighbor.node;
                    int neighborCol = neighbor.col;

                    if(col != neighborCol && !vis[neighborNode][neighborCol]){
                        vis[neighborNode][neighborCol] = true;
                        q.add(new Pair(neighborNode,neighborCol));
                        if(ans[neighborNode] == -1)
                        ans[neighborNode] = dist+1;
                    }
                }

            }
            dist++;
        }
        for(int i=0;i<n;i++)
        if(ans[i] == Integer.MAX_VALUE)
        ans[i] = -1;
        return ans;
    }
}