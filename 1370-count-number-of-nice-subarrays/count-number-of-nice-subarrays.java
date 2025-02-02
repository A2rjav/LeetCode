class Solution {
    public int atMostK(int nums[], int k){
        int l=0,r=0,odd =0,c=0,n = nums.length;

        while(r<n){
            if(nums[r] % 2 == 1){
                odd++;
            }
            while(odd > k){
                if(nums[l] %2 ==1){
                    odd--;
                }
                l++;
            }
            
            c+= r + 1-l;
            r++;
        }
        return c;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums,k) - atMostK(nums,k-1);
    }
}