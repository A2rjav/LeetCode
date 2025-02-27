class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int [] > q = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j] == 0) q.add(new int[]{i,j});
                else  mat[i][j] = -1;
            }
        }

        int [][] direction= {{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[]cell = q.remove();
            int r=cell[0], c= cell[1];
            for(int []dir : direction){
            int newRow = r+dir[0];
            int newCol = c+dir[1];

            if(newRow < 0 || newRow>=rows || newCol<0 || newCol >=cols || mat[newRow][newCol] != -1){
                continue;
            }

            mat[newRow][newCol] = mat[r][c]+1;
            q.add(new int[]{newRow,newCol});
            
            }
        }
        return mat;
    }
    
}