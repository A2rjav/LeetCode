class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int ans = Integer.MAX_VALUE,sum=0;
        int n= nums.length;
        boolean flag = false;
        for(int r=0;r<n;r++){
            sum += nums[r];
            while(sum>=target){
                flag = true;
                ans = Math.min(r-l+1,ans);
                sum -= nums[l++];
            }
        }
        return flag?ans:0;
    }
}