class Solution {
    Integer dp[][];
    int total = 0;
    public int findTargetSumWays(int[] nums, int target) {
        for(int n : nums) total += n;

        dp = new Integer[nums.length+1][2*total+1];
        return countSum(nums,target,0,0);
    }
    public int countSum(int nums[],int target,int i,int sum){
        if(i == nums.length)
        if(sum == target) return 1;
        else return 0;

        if(dp[i][sum+total] != null) return dp[i][sum+total];

        int plus = countSum(nums,target,i+1,sum-nums[i]);
        int minus = countSum(nums,target,i+1,sum+nums[i]);
        return dp[i][sum+total] = plus + minus;
    }
}