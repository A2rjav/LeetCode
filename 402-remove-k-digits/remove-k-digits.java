class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && k>0 && st.peek() - '0' > num.charAt(i)- '0'){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        if(st.isEmpty()) return "0";
        while(k>0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();

        while(sb.length()>0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length()== 0? "0" : sb.toString();
    }
}