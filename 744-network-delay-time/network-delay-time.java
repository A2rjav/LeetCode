class Solution {
    class Pair{
        int n,wt;
        Pair(int n, int wt){
            this.n = n;
            this.wt = wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for( int time[] : times){
            adj.get(time[0]-1).add(new Pair(time[1]-1,time[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1] = 0;

        pq.add(new Pair(k-1,0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int u = curr.n;
            int time = curr.wt;
            
            for(Pair neighbor : adj.get(u)){
                int v = neighbor.n;
                int vTime = neighbor.wt;

                if(time+ vTime < dist[v]){
                    dist[v] = time + vTime;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }
        int maxTime =0;
        for(int d: dist){
            if(d == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime,d);
        }
        return maxTime;
    }
}