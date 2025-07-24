class Solution {
    int dirs[][]={{-1,0},{1,0},{0,1},{0,-1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m= maze.length;
        int n = maze[0].length;

        boolean vis[][]= new boolean[m][n];
        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++){
            if(maze[i][j] == '+')
            vis[i][j] = true;
        }
        vis[entrance[0]][entrance[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0],entrance[1]});
        
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            cnt++;
            for(int i=0;i<size;i++){
                int [] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                
                for(int dir[] : dirs){
                    int newR = dir[0] + r;
                    int newC = dir[1] + c;

                    if(newR>=0 && newC>=0 && newR<m && newC<n && maze[newR][newC] == '.' && !vis[newR][newC] ){
                        if (newR == 0 || newR == m - 1 || newC == 0 || newC == n - 1) 
                        return cnt;
                        
                        vis[newR][newC] =true;
                        q.add(new int[]{newR,newC});
                    }
                }
            }
        }
        return -1;


    }
    
}