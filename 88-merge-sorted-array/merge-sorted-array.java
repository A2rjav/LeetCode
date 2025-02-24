class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        int len = m+n;
        int gap = (int) Math.ceil(len/2.0);

        while(gap > 0){
            int l = 0;
            int r = l + gap;
            while(r < len){
                if(nums1[l] > nums1[r]){
                    int temp = nums1[l];
                    nums1[l] = nums1[r];
                    nums1[r] = temp;
                }
                l++;
                r++;
            }
            if(gap == 1) break;
            gap = (int) Math.ceil(gap/2.0);
        }
    }
}