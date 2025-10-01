class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0, high = m*n -1;

        while(low<=high){
            int mid = (low + high)>>1;
            int row = mid/m, col = mid%m;

            if(matrix[row][col] == target ) return true;
            if(matrix[row][col] > target) high = mid-1;
            else low = mid+1;
        }
        return false;
        
    }
}