class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0,n = nums.length;
        int zeroes =0;
        int ans = 0;

        for(;r<n;r++){
            if(nums[r]==0) zeroes++;
            while(zeroes > k){
                if(nums[l++] == 0)
                zeroes--;
            }
            int len = r-l+1;
            ans = Math.max(ans,len);
        }
        return ans;
    }
}