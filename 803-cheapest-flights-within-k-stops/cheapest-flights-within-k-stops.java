class Solution {
    class Pair{
        int n,wt;
        Pair(int n,int wt){
            this.n = n;
            this.wt =wt;
        }
    }
    class Info{
        int n,wt,stop;
        Info(int n,int wt, int stop){
            this.n = n;
            this.wt = wt;
            this.stop = stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int flight[] : flights){
            adj.get(flight[0]).add(new Pair(flight[1],flight[2]));
        }

        int dist[] = new int [n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));

        while(!q.isEmpty()){
            Info curr = q.remove();

            for(Pair neighbor : adj.get(curr.n)){
                if(dist[neighbor.n] > curr.wt + neighbor.wt && curr.stop <= k){    
                    dist[neighbor.n] = curr.wt + neighbor.wt;
                    q.add(new Info(neighbor.n,curr.wt + neighbor.wt,curr.stop +1));
                }
            }
        }
        if(dist[dst] != Integer.MAX_VALUE) return dist[dst];
        return -1;
    }
}