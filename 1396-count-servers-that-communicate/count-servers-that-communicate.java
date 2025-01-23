class Solution {
    public int countServers(int[][] grid) {
        int c=0;
        int rows[] = new int[grid.length];
        int cols[] = new int[grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] ==1){
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)){
                    c++;
                }
            }
        }
        return c;
    }
}