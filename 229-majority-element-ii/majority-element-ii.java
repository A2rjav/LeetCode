class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int threshold = nums.length/3;
        List<Integer> ans = new ArrayList<>();
        for(int n : map.keySet()){
            if(map.get(n) > threshold) ans.add(n);
        }
        return ans;
    }
}