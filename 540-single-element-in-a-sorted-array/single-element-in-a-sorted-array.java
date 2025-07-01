class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0,n = nums.length;
        int r = n-1;

        if(n==1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        while(l<=r){
            int m = (l + r)>>1;

            if(nums[m] != nums[m-1] && nums[m] != nums[m+1])
            return nums[m];

            if((m%2 == 1 && nums[m-1] == nums[m]) || (m%2==0 && nums[m] == nums[m+1])){
                l = m+1;
            }else r = m-1;
            
        }

        return -1;
    }
}