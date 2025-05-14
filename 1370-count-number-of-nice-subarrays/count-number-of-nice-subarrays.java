class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums,k) - atMostK(nums,k-1);
    }

    public int atMostK(int []nums, int k){
        int c=0,n = nums.length,ans =0;

        for(int l=0,r=0;r<n;r++){
            if(nums[r]%2 == 1) c++;
            while(c>k){
                if(nums[l] % 2 == 1) c--;
                l++;
            }
            ans += (r-l+1);
        }
        return ans;
    }
}