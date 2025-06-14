class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum %2 != 0 ) return false;
        sum /=2;
        dp = new Boolean[n+1][sum+1];
        return subsetSum(nums,n-1,sum);
    }
    public boolean subsetSum(int []nums,int n,int sum){
        if(n<0) return false;
        if(sum ==0 ) return true;

        if(dp[n][sum] != null ) return dp[n][sum];

        if(nums[n]<=sum){
            boolean accept = subsetSum(nums,n-1,sum-nums[n]);
            boolean decline = subsetSum(nums,n-1,sum);
            return dp[n][sum] = accept || decline;
        }
        else{
            return dp[n][sum] = subsetSum(nums,n-1,sum);
        }
    }
}