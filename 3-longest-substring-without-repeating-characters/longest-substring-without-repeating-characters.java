class Solution {
    public int lengthOfLongestSubstring(String s) {

int c=0;
        for(int i=0;i<s.length();i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=i;j<s.length();j++){
                if(set.contains(s.charAt(j))){
                    break;
                }else{
                    set.add(s.charAt(j));
                }
                c= Math.max(c,set.size());
            }
        }
        return c;
    }
}