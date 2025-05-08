class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int a : asteroids){
            boolean destroyed = false;
            while(!st.isEmpty() && a<0 && st.peek() > 0){
                int top = st.peek();

                if(top < -a) st.pop();
                else if(top == -a){
                    destroyed = true;
                    st.pop();
                    break;
                }else{
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed)
            st.push(a);
        }
        int n = st.size();
        int ans[] = new int[n];
        for(int i=n-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}