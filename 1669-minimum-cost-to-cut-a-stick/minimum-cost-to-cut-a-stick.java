class Solution {
    Integer dp[][];

    public int minCost(int m, int[] cuts) {
        Arrays.sort(cuts);
        int n = cuts.length;

        dp = new Integer[n+2][n+2];
        int newCuts[] = new int[n+2];
        newCuts[0] = 0;
        newCuts[newCuts.length-1] = m;
        for(int i=0;i<n;i++) newCuts[i+1] = cuts[i];
        int result = solve(newCuts,0,newCuts.length-1);
        return result;
    }
    public int solve(int []cuts,int i,int j){
        if(i+1 == j) return 0;

        if(dp[i][j] != null ) return dp[i][j];
        int minCost = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int cost = solve(cuts,i,k) + solve(cuts,k,j) + (cuts[j] - cuts[i]);
            minCost = Math.min(minCost,cost);
        }
        return dp[i][j] = minCost;
    }
}