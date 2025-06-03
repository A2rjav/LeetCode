class Solution {
    class Pair{
        int n,wt;
        Pair(int n,int wt){
            this.n = n;
            this.wt = wt;
        }
    }
    class Info{
        int n,wt,stops;
        Info(int n,int wt, int stops){
            this.n = n;
            this.wt = wt;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int flight[] : flights){
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            adj.get(u).add(new Pair(v,cost));
        }
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));

        int stop = 0;
        while(!q.isEmpty()){
            Info curr = q.poll();
            int node = curr.n;
            int wt = curr.wt;
            int stops = curr.stops;

            for(Pair neighbor : adj.get(node)){
                if(dist[neighbor.n] > neighbor.wt + wt && stops <=k ){
                    dist[neighbor.n] = neighbor.wt + wt;
                    q.add(new Info(neighbor.n,dist[neighbor.n],stops+1));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst]; 
    }
}