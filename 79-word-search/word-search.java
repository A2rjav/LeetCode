class Solution {
    int len,m,n;
    public boolean exist(char[][] board, String word) {
        len = word.length();
        m = board.length;
        n = board[0].length;

        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++){
            if(backtrack(board,word,i,j,0)){
                return true;
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board,String word,int i,int j,int idx){
        if(idx==len) return true;

        if(i<0 || j<0 || i>=m || j>=n || board[i][j] != word.charAt(idx)) return false; 
        char temp = board[i][j];
        board[i][j] = '#'; 

        boolean found = backtrack(board,word,i+1,j,idx+1)||backtrack(board,word,i-1,j,idx+1)||backtrack(board,word,i,j+1,idx+1)||backtrack(board,word,i,j-1,idx+1);
        
        board[i][j] = temp;
        return found;
            
    }
}