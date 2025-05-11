class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l =0,r=0;
        Set<Character> set = new HashSet<>();
        int ans = 0;

        for(;r<s.length();r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            ans = Math.max(ans,set.size());
            
        }
        System.out.print(set);
        return ans;
    }
}