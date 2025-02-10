class Solution {
    public String helper(String str){
        int [] freq = new int[26];
        for(char ch : str.toCharArray()){
            freq[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<freq.length;i++){
            sb.append("" + freq[i]);
            sb.append('#');
        }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        TreeMap<String,List<String>> map = new TreeMap<>();
        for(String str : strs){
            String hash = helper(str);
            System.out.println(hash);
            if(!map.containsKey(hash)){
                map.put(hash,new ArrayList<>());
            }
            map.get(hash).add(str);
        } 
        List<List<String>> ans = new ArrayList<>();
        for(List<String> list:map.values()){
        Collections.sort(list);

            ans.add(list);
        }
        return ans;
    }
}