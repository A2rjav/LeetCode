class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int i=0;
        int c=0;
        while(i<s.length()){
            if(s.charAt(i) =='(') st.push('(');
            else if(st.isEmpty()){
                c++;
            }else st.pop();
            i++;
        }
        return c+st.size();
    }
}