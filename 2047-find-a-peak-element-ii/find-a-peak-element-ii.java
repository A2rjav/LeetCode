class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0,high = m-1;

        while(low <= high){
            int mid = (low + high )>>1;
            int max =findMaxIndex(mat,mid,n,m);

            int left = mid-1 >= 0 ? mat[max][mid-1] : -1;
            int right = mid+1 < m ? mat[max][mid+1] : -1;

            if(mat[max][mid]>left && mat[max][mid]>right ) return new int[]{max,mid};
            else if(mat[max][mid] < left ) high = mid-1;
            else low = mid+1;
        }
        return new int[]{-1,-1};
    }
    public int findMaxIndex(int[][] mat,int col,int n,int m){
        int max =Integer.MIN_VALUE;
        int idx = -1;
        for(int i=0;i<n;i++){
            if(mat[i][col] > max){
                idx = i;
                max = mat[i][col];
            } 
        }
        return idx;
    }
}