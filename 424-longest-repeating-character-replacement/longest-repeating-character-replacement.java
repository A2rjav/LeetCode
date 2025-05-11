class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0,ans=0;
        Map<Character,Integer> map = new HashMap<>();
        int maxFreq =0;

        for(;r<s.length();r++){
            char left = s.charAt(l);
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            maxFreq = Math.max(maxFreq,map.get(s.charAt(r)));

            while(r-l+1-maxFreq > k){
                map.put(left,map.get(left)-1);
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}