class Solution {
    class Info{
        int r,c,effort;
        Info(int r,int c,int effort){
            this.r = r;
            this.c = c;
            this.effort = effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Info> pq = new PriorityQueue<>((a,b) -> a.effort - b.effort);
        int r = heights.length;
        int c = heights[0].length;
        int [][] effort = new int[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                effort[i][j] = Integer.MAX_VALUE;
            }
        }
        effort[0][0] = 0;   

        pq.add(new Info(0,0,0));

        int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()){
            Info curr = pq.remove();
            int row = curr.r;
            int col = curr.c;
            int diff = curr.effort;

            if(row == r-1 && col == c-1) return diff;
            for(int [] dir : dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow>=0 && newCol >=0 && newRow <r && newCol<c){
                    int newEffort = Math.max(Math.abs(heights[newRow][newCol] - heights[row][col]),diff);
                    if(newEffort < effort[newRow][newCol]){
                        effort[newRow][newCol] = newEffort;
                        pq.add(new Info(newRow,newCol,newEffort));
                    }
                    
                }
            }
        }
        return 0;
    }
}