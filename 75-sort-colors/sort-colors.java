class Solution {
    public void sortColors(int[] nums) {
        int z=0,o=0,t=0;
        for(int n : nums){
            if(n == 0) z++;
            else if(n == 1) o++;
            else t++;
        }
        int i=0;
        while(z-->0) nums[i++] = 0;
        while(o-->0) nums[i++] = 1;
        while(t-->0) nums[i++] = 2;
    }
}