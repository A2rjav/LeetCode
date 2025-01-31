class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();

        int l = 0;
        int ans =0;
        int maxFreq = 0;

        for(int r=0;r<s.length();r++){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0) +1);
            maxFreq = Math.max(map.get(s.charAt(r)),maxFreq);

            while(r-l+1-maxFreq > k){
                char leftChar = s.charAt(l);
                map.put(leftChar,map.get(leftChar) -1);
                l++;
                
            }   

            ans = Math.max(ans,r-l+1);
        }
        return ans;


        
    }
}