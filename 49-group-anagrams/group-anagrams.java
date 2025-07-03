class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String str : strs){
            String newStr = createFreq(str);
            if(!map.containsKey(newStr)){
                map.put(newStr,new ArrayList<>());
            }
            map.get(newStr).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
            for(Map.Entry<String,ArrayList<String>> entry : map.entrySet())
        ans.add(entry.getValue());
        return ans;
    }
    public String createFreq(String str){
        int arr[] = new int[26];
        for(char ch:str.toCharArray()){
            arr[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int count : arr) {
            sb.append(count).append('#');
        }
        return sb.toString();
    }
}