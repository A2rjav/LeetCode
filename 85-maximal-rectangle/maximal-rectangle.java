class Solution {
    int n,m;
    public int maximalRectangle(char[][] matrix) {
        n = matrix.length;
        if(n==0) return 0;
        m = matrix[0].length;
        int prefixSum[][] = new int[n][m];

        int sum;

        for(int j=0;j<m;j++){
            sum = 0;
            for(int i=0;i<n;i++){
                sum += matrix[i][j]-'0';
                if(matrix[i][j] == '0') sum = 0;
                prefixSum[i][j] = sum;
            }
        }
        int maxArea = 0;
        for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea,largestRectangle(prefixSum[i]));
        }
        return maxArea;
    }
    public int largestRectangle(int arr[]){
        int nsr[] = new int[m];
        int nsl[] = new int[m];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<m;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nsl[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        for(int i= m-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nsr[i] = st.isEmpty() ? m : st.peek();
            st.push(i);
        }

        int maxArea = 0;
        for(int i=0;i<m;i++){

            int width = nsr[i] - nsl[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;


    }
}