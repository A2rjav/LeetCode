class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nsl[] = new int[n];
        int nsr[] = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            nsl[i] = st.isEmpty()? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            nsr[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            int width = nsr[i] - nsl[i] - 1;
            int height = heights[i];
            int area = height * width;
            ans = Math.max(ans,area);
        }
        return ans;
    }
}