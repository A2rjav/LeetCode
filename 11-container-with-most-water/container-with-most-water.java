class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int area = 0;
        
        int i = 0,j=n-1;

        while(i<j){
            int ht = Math.min(height[i],height[j]);
            int wt = j-i;
            area = Math.max(area,ht*wt);
            if(height[i]>height[j]) j--;
            else i++;
        }
        return area;
    }
}