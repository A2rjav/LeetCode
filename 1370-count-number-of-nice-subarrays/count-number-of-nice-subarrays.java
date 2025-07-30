class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums,k) - atMostK(nums,k-1);
    }
    public int atMostK(int nums[],int k){
        int l=0,n = nums.length;
        int cnt= 0;
        int ans=0;
        for(int r=0;r<n;r++){
            if(isOdd(nums[r]))
            cnt++;

            while(cnt>k){
                if(isOdd(nums[l++]))
                cnt--;
            }

            ans += (r-l+1);

        }
        return ans;
    }
    public boolean isOdd(int n){
        return n%2==1;
    }
}