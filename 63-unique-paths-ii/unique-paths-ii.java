class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return countWays(obstacleGrid,m-1,n-1,new Integer[m][n]);
    }
    public int countWays(int [][]obstacleGrid,int m,int n,Integer dp[][]){
        if(m<0 || n<0 || obstacleGrid[m][n] == 1) return 0;
        if(m==0 && n==0) return 1;
        if(dp[m][n] != null) return dp[m][n];
        return dp[m][n] = countWays(obstacleGrid,m-1,n,dp) + countWays(obstacleGrid,m,n-1,dp);
    }
}