class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();

        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String temp = new String(charArray);

            if(map.containsKey(temp)){
                map.get(temp).add(str);
            }else{
                map.put(temp,new ArrayList<>());
                map.get(temp).add(str);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,ArrayList<String>> entry : map.entrySet()){
            // String str = entry.value();
            ans.add(entry.getValue());
        } 
        return ans;
    }
}