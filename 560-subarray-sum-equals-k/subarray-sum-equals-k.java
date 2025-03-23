class Solution {
    public int subarraySum(int[] nums, int k) {
        int c =0;
        int sum =0;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int n: nums){
            sum += n;
            if(map.containsKey(sum - k)) c+= map.get(sum - k);
            
            map.put(sum,map.getOrDefault(sum,0)+1);

        }
        return c;
    }
}