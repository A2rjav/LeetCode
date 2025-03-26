class Solution {
    int[] rank;
    int[] par;
    public int makeConnected(int n, int[][] connections) {
        par = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++)
        par[i] = i;

        int cntExtra = 0;
        int m= connections.length;
        for(int i=0;i<m;i++){
            int u= connections[i][0];
            int v = connections[i][1];

            if(find(u) == find(v)) cntExtra++;
            else union(u,v);
        }

        int cntC =0;
        for(int i=0;i<n;i++){
            if(find(i) == i) cntC++;
        }
        int ans = cntC-1;
        if(cntExtra >= ans ) return ans;
        return -1;
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