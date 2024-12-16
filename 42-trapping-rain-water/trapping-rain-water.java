class Solution {
    public int trap(int[] height) {
        int ans =0;
        int n = height.length;
        int lb[]= new int[height.length];
        int rb[] = new int[n];

        lb[0] = height[0];
        for(int i=1;i<height.length;i++){
            lb[i] = Math.max(height[i], lb[i-1]);
        }

        rb[n-1] = height[n-1];
        for(int i = n-2; i>=0;i--){
            rb[i] = Math.max(height[i] , rb [i+1]);
        }
        for(int i=0;i<n;i++){
            ans += (Math.min(lb[i],rb[i]) - height[i]);
        }
        return ans;
    }
}
// lb = Math.max(height[i],lb);
            // rb = Math.max(height[i],rb);
            // wl = Math.min(lb,rb);
            // int water = (wl - height[i]);
            // ans += water;