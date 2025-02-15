class Solution {
    Map<Character,String> map;
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        ans = new ArrayList<>();
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(digits,0,new StringBuilder());
        return ans;
    }
    public void backtrack(String digits,int idx,StringBuilder sb){
        if(idx == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(idx));
        for(char c : letters.toCharArray()){
            sb.append(c);
            backtrack(digits,idx +1,sb);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}