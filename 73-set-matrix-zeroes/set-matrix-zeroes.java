class Solution {
    public void setZeroes(int[][] matrix) {
        Stack<int[]> st = new Stack<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    st.push(new int[]{i,j});
                }
            }
        }
        while(!st.isEmpty()){
            int []arr = st.pop();
            int a=arr[0];
            int b = arr[1];
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(i == a || j == b){
                        matrix[i][j] =0;
                    }
                }
            }
        }
    }
}