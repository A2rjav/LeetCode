class Solution {
    List<List<String>> ans = new ArrayList<>();
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n= n;
        char [][]board = new char[n][n];
        for(int i=0;i<n;i++) Arrays.fill(board[i],'.');
        backtrack(board,0,n);
        return ans;
        
    }
    public boolean isValid(int row,int col,char [][]board){
        // up
        for(int i=row-1;i>=0;i--){
            if(board[i][col] == 'Q')return false;
        }
        // left
        for(int i=0;i<col;i++) 
        if(board[row][i] == 'Q') 
        return false;

        // diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q') 
            return false;
        }
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(board[i][j] == 'Q') 
            return false;
        }

        return true;

    }
    public void backtrack(char[][]board,int row,int n){
        if(row == n ){
            List<String> curr = new ArrayList<>();
            for(char[]b : board){
                curr.add(new String(b));
            }
            ans.add(curr);
            return;
        }
        for(int col=0;col<n;col++){
            if(isValid(row,col,board)){
                board[row][col] ='Q';
                backtrack(board,row+1,n);
                board[row][col] ='.';
            }
        }
    }
}