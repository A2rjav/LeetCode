class Solution {
    public String frequencySort(String s) {
        Map <Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        ArrayList<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> (b.getValue() - a.getValue()));

        for(Map.Entry<Character,Integer> entry : list){
            char ch = entry.getKey();
            int freq = entry.getValue();
            for(int i=0;i<freq;i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}