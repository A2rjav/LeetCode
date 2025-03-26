class Solution {
    int[] rank;
    int[] par;
    public int removeStones(int[][] stones) {
        int n = stones.length;
        par = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++)
        par[i] = i;

        Map<Integer,Integer> xMap = new HashMap<>();
        Map<Integer,Integer> yMap = new HashMap<>();

        int connectedComponents =0;
        for(int i=0;i<n;i++){
            int x = stones[i][0];
            int y = stones[i][1];

            if(xMap.containsKey(x)) union(xMap.get(x),i);
            xMap.put(x,i);

            if(yMap.containsKey(y)) union(yMap.get(y),i);
            yMap.put(y,i);
        }

        boolean[] visited = new boolean[n]; 
        for (int i = 0; i < n; i++) {
            int root = find(i);
            if (!visited[root]) {
                visited[root] = true;
                connectedComponents++;
            }
        }
        return n - connectedComponents;
    }
    public int find(int x){
        if(par[x] == x) return x;
        return par[x] = find(par[x]);
    }
    public void union(int a,int b){
        int parA = find(a);
        int parB= find(b);

        if(rank[parA] < rank[parB])
        par[parA] = parB;
        else if(rank[parA] > rank[parB])
        par[parB] = parA;
        else 
        par[parB] = parA;
        rank[parA]++;
    }
}