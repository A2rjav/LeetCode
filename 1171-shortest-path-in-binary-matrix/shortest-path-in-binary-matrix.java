class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0,0,1});


        boolean [][]vis = new boolean[n][n];
        vis[0][0] = true;

        int dirs[][]= {{-1,0},{1,0},{0,1},{0,-1},{1,-1},{-1,-1},{1,1},{-1,1}};
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int row = curr[0],col = curr[1], dist = curr[2];

            if(row == n-1 && col == n-1 ) return dist; 

            for(int[] dir : dirs){
                int newR = row + dir[0];
                int newC = col + dir[1];

                if(newR<n && newR>=0 && newC>=0 && newC<n && grid[newR][newC] == 0 && !vis[newR][newC] ){
                    q.add(new int[]{newR,newC,dist+1});
                    vis[newR][newC] = true;
                }
            } 
        }
        return -1;
    }
}