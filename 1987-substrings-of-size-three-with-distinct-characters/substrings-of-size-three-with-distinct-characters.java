class Solution {
    public int countGoodSubstrings(String s) {
        int n=s.length();
        if(n<3) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<3;i++)
        map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        int cnt=0;
        if(map.size()==3) cnt++;
        
        int i=0,j=2;
        while(j<n-1){
            j++;
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            
            
            map.put(s.charAt(i),map.get(s.charAt(i))-1);
            if(map.get(s.charAt(i))==0) map.remove(s.charAt(i));
            i++;

            if(map.size() == 3) cnt++;
        }
        return cnt;
    }
}