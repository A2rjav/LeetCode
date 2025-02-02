class Solution {
    public int numberOfSubstrings(String s) {
        int c=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int l=0,r=0; r< s.length(); r++){
            char rightChar = s.charAt(r);
            map.put(rightChar, map.getOrDefault(rightChar,0)+1);

            while(map.size() == 3){
                c+= s.length() - r;
                char leftChar = s.charAt(l);
                map.put(leftChar,map.get(leftChar) -1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                l++;
            }

        }
        return c;
    }
}