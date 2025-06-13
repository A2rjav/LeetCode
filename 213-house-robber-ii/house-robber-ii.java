class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        
        return Math.max(rob1(nums,1,n-1),rob1(nums,0,n-2));
    }
    public int rob1(int nums[],int start,int end){
        int prev1 = 0;
        int prev2 = 0;

        for(int i=start;i<=end;i++){
            int curr = Math.max(nums[i]+ prev2,prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;

    }
}