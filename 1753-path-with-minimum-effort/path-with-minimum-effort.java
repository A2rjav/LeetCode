class Solution {
    class Pair{
        int x,y,diff;
        Pair(int x,int y,int diff){
            this.x = x;
            this.y = y;
            this.diff = diff;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> q =new PriorityQueue<>((a,b) -> a.diff - b.diff);
        q.add(new Pair(0,0,0));
    
        int n = heights.length;
        int m = heights[0].length;
        int[][] util = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            Arrays.fill(util[i], Integer.MAX_VALUE);
        }
        util[0][0] = 0;

        while(!q.isEmpty()){
            Pair curr= q.poll();
            int x = curr.x;
            int y = curr.y;
            int diff = curr.diff;
            if(x == n-1 && y == m-1) return diff;
            int dirs[][] = {{-1,0},{1,0},{0,1},{0,-1}};
            for(int dir[] : dirs){
                int newX = dir[0]+x;
                int newY = dir[1] +y;
                if(newX >=0 && newY >=0 && newX <n && newY<m){
                    int newDiff = Math.max(diff,Math.abs(heights[newX][newY] - heights[x][y]));
                    if(newDiff < util[newX][newY]){
                        util[newX][newY] = newDiff;
                        q.add(new Pair(newX,newY,newDiff));
                    }
                    
                }
            }
        }
        return 0;
    }
}