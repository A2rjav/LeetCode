class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int n = s.length();
        int l =0;
        int ans = 0;
        for(int i=0;i<n;i++){
            char right= s.charAt(i);


            map.put(right, map.getOrDefault(right,0)+1);
            while(map.get(right) > 1){
                char left = s.charAt(l);
                map.put(left, map.get(left) -1);
                if(map.get(left) == 0) map.remove(left);
                l++;
            }

            ans = Math.max(ans, map.size());
        }
        return ans;
    }
}