class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int ans = 0;
        for(int n:set){
            int num = n;
            if(set.contains(num-1)) continue;
            int consecutive =1;
            
            while(set.contains(num+1)){
                consecutive++;
                num++;
            }
            ans = Math.max(ans,consecutive);
        }
        return ans;
    }
}