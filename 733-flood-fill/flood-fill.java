class Solution {
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc] == color) return image;
        m = image.length;
        n = image[0].length;
        int og = image[sr][sc];
        int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int curr[] = q.poll();
            
            for(int dir[] : dirs){
                int newR = dir[0] + curr[0];
                int newC = dir[1] + curr[1];

                if(newR >=0 && newR < m && newC>=0 && newC <n && image[newR][newC] == og){
                    image[newR][newC] = color;
                    q.add(new int[]{newR,newC});
                }
            }
        }
        return image;
    }
}