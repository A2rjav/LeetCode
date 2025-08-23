class Solution {
    Integer dp[][];
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int newNums[] = new int[n+2];

        dp = new Integer[n+2][n+2];
        newNums[0] = 1;
        newNums[newNums.length-1] = 1;
        for(int i=0;i<n;i++) newNums[i+1] = nums[i];

        return solve(newNums,1,n);
    }
    public int solve(int nums[], int i,int j){
        if(i>j) return 0;
        if(dp[i][j] != null ) return dp[i][j];
        int maxI = Integer.MIN_VALUE;
        for(int ind = i;ind<=j;ind++){
            int cost = nums[i-1] * nums[j+1] * nums[ind] + solve(nums,i,ind-1) + solve(nums,ind+1,j);
            maxI = Math.max(maxI,cost);
        }
        return dp[i][j] = maxI;
    }
}