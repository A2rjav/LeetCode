class Solution {
    Integer [][]dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Integer[m][n];
        return calculateSum(grid,m-1,n-1);
    }
    public int calculateSum(int [][]grid,int m,int n){
        if(m<0 || n<0) return Integer.MAX_VALUE;
        if(m == 0 && n==0) return grid[m][n];
        if(dp[m][n] != null) return dp[m][n];
        return dp[m][n] = Math.min(calculateSum(grid,m-1,n), calculateSum(grid,m,n-1)) + grid[m][n];
    }
}