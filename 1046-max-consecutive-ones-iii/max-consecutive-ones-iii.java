class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0;
        int zeroes = 0,ans =0;
        
        for(;r<nums.length;r++){
            if(nums[r] == 0) zeroes++;
            while(zeroes > k){
                if(nums[l] == 0){
                    zeroes--;
                }
                l++;

            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}