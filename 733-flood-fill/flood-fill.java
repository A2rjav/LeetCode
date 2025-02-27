class Solution {
    int r, c, originalColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        r = image.length;
        c = image[0].length;
        originalColor = image[sr][sc];

        if (originalColor != color) { // Prevent infinite recursion if color is same
            dfs(image, sr, sc, color);
        }

        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color) {
        // Base Case: Out of bounds or already a different color
        if (sr < 0 || sr >= r || sc < 0 || sc >= c || image[sr][sc] != originalColor) {
            return;
        }

        // Fill the cell
        image[sr][sc] = color;

        // Explore all four directions
        dfs(image, sr + 1, sc, color);
        dfs(image, sr - 1, sc, color);
        dfs(image, sr, sc + 1, color);
        dfs(image, sr, sc - 1, color);
    }
}
