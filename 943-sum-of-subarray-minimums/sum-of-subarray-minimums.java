class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007;
        int n = arr.length;
        int prevSmaller[] = new int[n];
        int nextSmaller[] = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            prevSmaller[i] = st.isEmpty()? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nextSmaller[i] = st.isEmpty() ? n:st.peek();
            st.push(i);
        }

        long ans =0;
        for(int i=0;i<n;i++){
            long left = i - prevSmaller[i];
            long right = nextSmaller[i] - i;

            ans = (ans + ((left * right% mod ) * arr[i]) %mod)%mod;
        }

        return (int ) ans;

    }
}