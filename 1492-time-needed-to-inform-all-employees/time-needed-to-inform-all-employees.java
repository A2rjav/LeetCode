class Solution {
    int ans;
    class Pair{
        int node;
        int t;
        Pair(int n,int t){
            node = n;
            this.t = t;
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n==1) return informTime[0];
        ans = informTime[headID];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i =0;i<n;i++)
        adj.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            int u = manager[i];
            if(u==-1) continue;
            adj.get(u).add(new Pair(i,informTime[i]));
        }
        int dist = ans;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(headID,dist));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair curr = q.poll();
                int node = curr.node;
                int t = curr.t;

                ans = Math.max(ans,dist);
                for(Pair neighbor : adj.get(node)){
                    int neighNode = neighbor.node;
                    int neighT = neighbor.t;
                    dist = neighT+t;
                    q.add(new Pair(neighNode,dist));
                    
                }
            }
        }
        return ans;
    }
}