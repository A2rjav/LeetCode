class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        int l=0,r=0;
        int minLen = Integer.MAX_VALUE;
        int sIdx = -1;
        int cnt=0;

        for(char ch:t.toCharArray())
        map.put(ch,map.getOrDefault(ch,0)+1);

        int m = s.length(),n=t.length();
        while(r<m){
            char ch = s.charAt(r);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)>=0)
                cnt++;
                
            } 
            while(cnt == n){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    sIdx = l;
                }
                char leftChar = s.charAt(l);
                if(map.containsKey(leftChar)){
                    map.put(leftChar,map.get(leftChar)+1);
                    if(map.get(s.charAt(l))>0) cnt--;
                }
                l++;
            }
            r++;
        }

        return sIdx == -1? "" : s.substring(sIdx,sIdx+minLen);
    }
}