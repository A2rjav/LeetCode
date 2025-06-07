class Solution {
    int[] rank;
    int[] par;
    public int makeConnected(int n, int[][] connections) {
        int wires = 0;
        rank = new int[n];
        par = new int[n];

        for(int i=0;i<n;i++) par[i] = i;
        for(int [] connection : connections){
            int u = connection[0];
            int v = connection[1];

            int parU = find(u);
            int parV = find(v);
            
            if(parU == parV){
                wires++;
            }
            else 
            union(parU,parV); 
        }
        int cntC = 0;
        for(int i=0;i<n;i++){
            if(find(i) == i ) cntC++;
        }

        int wiresNeeded = cntC-1;
        if(wires>=wiresNeeded) return wiresNeeded;
        return -1;
    }
    public int find(int x){
        if(par[x] == x) return x;
        return par[x] = find(par[x]);
    }

    public void union(int x,int y){
        int parX = find(x);
        int parY = find(y);

        if(rank[parX]> rank[parY]){
            par[parY] = parX;
        }
        else if(rank[parX]< rank[parY]){
            par[parX] = parY;
        }
        else{
            par[parX] = parY;
            rank[parX]++;
        }
    }
}