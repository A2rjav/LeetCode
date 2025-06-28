class Solution {
    int n;
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        n = s.length();
        backtrack(s,new StringBuilder(),0);
        return ans;
    }
    public void backtrack(String s,StringBuilder sb,int i){
        if(i==n){
            ans.add(sb.toString());
            return;
        }
        if(Character.isDigit(s.charAt(i))){
            sb.append(s.charAt(i));
            backtrack(s,sb,i+1);
            sb.deleteCharAt(sb.length()-1);
        }else{
            
            sb.append(Character.toLowerCase(s.charAt(i)));
            backtrack(s,sb,i+1);
            sb.deleteCharAt(sb.length()-1);

            sb.append(Character.toUpperCase(s.charAt(i)));
            backtrack(s,sb,i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}