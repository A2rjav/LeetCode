class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int currMax =0;
        int maxI=0;
        int c=0;

        for(int i=0;i<n;i++){
            maxI = Math.max(maxI,i+nums[i]);

            if(i==currMax){
                c++;
                currMax = maxI;
            }
            if(currMax >=n-1) break;
        }
        return c;
        
    }
}