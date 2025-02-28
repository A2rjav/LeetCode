class Solution {
    int r, c, originalColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        r = image.length;
        c = image[0].length;
        originalColor = image[sr][sc];

        if (originalColor != color) {
            dfs(image, sr, sc, color);
        }

        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color) {
        image[sr][sc] = color;
        int [][] directions = {{1,0},{-1,0},{0,1},{0,-1,}};
        for( int[] dir : directions){
            int newRow = dir[0]+ sr;
            int newCol = dir[1] + sc;

            if(newRow >=0 && newRow <r && newCol >=0 && newCol <c && image[newRow][newCol] == originalColor){
                dfs(image,newRow,newCol,color);
            }
        }
    }
}
