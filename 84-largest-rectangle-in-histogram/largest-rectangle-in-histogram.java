class Solution {
    public int largestRectangleArea(int[] heights) {
        int []nsl = new int[heights.length];
        int []nsr = new int[heights.length];

        Stack<Integer> s = new Stack<>();

        for(int i=0;i<heights.length;i++ ){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            nsl[i] = s.isEmpty() ? -1:s.peek();
            s.push(i);
        }

        s.clear();
        for(int i= heights.length-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            nsr[i] = s.isEmpty() ? heights.length : s.peek();
            s.push(i);
        }
        int ans =0;
        for(int i=0;i<heights.length;i++){
            int height = heights[i];
            int width = nsr[i] - nsl[i] -1;
            int area = height * width;
            ans = Math.max(ans,area);
        }
        return ans;

    }
}