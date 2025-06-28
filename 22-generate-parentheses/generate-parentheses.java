class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n,new StringBuilder(),0,0);
        return ans;
    }
    public void backtrack(int n,StringBuilder sb,int l,int r){
        if(sb.length() == 2*n){
            ans.add(sb.toString());
            return;
        }

        if(l<n){
            sb.append('(');
            backtrack(n,sb,l+1,r);
            sb.deleteCharAt(sb.length()-1);
        }
        if(r<l){
            sb.append(')');
            backtrack(n,sb,l,r+1);
            sb.deleteCharAt(sb.length()-1);

        }


    }
}