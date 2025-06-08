class Solution {
    class DSU{
        int size[];
        int par[];
        public DSU(int n){
            size = new int[n];
            par = new int[n];

            for(int i=0;i<n;i++){
                par[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x){
            if(par[x] == x) return x;
            return par[x] = find(par[x]);
        }

        public void union(int a, int b){
            int parA = find(a);
            int parB = find(b);

            if(parA == parB) return; // Prevent over-merging and size inflation

            if(size[parA] < size[parB]){
                par[parA] = parB;
                size[parB] += size[parA];
            } else {
                par[parB] = parA;
                size[parA] += size[parB];
            }
        }

        public int getSize(int x){
            return size[find(x)];
        }
    }
    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n*n);
        int dirs[][]= new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++){
            if(grid[i][j] == 1){
                int node = i*n+j;
                for(int []dir : dirs){
                    int nx = dir[0] + i;
                    int ny = dir[1] + j;
                    if(nx>=0 && nx<n && ny>=0 && ny < n && grid[nx][ny] == 1){
                        int neighborNode = n*nx + ny;
                        dsu.union(node,neighborNode);
                    }
                }
            }
        }

        int ans = 0;
        boolean hasZero = false;

        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++){
            if(grid[i][j] == 0 ){
                hasZero = true;
                Set<Integer> set = new HashSet<>();
                int size = 0;

                for(int dir[] : dirs){
                    int nx = dir[0] + i;
                    int ny = dir[1] + j;
                    if(nx>=0 && nx<n && ny>=0 && ny < n && grid[nx][ny] == 1){
                        int neighborNode = dsu.find(n*nx + ny);
                        if(!set.contains(neighborNode)){
                            size += dsu.getSize(neighborNode);
                            set.add(neighborNode);
                        }
                    }
                }
                ans = Math.max(ans,size+1);
            }
        }
        if(!hasZero) return n*n;
        return ans;
    }
}