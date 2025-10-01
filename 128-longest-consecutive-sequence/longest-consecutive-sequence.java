class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set =new HashSet<>();
        for(int num : nums ) set.add(num);
        int ans = 0;

        for(int n : set){
            if(!set.contains(n-1)){
                int cnt = 1;
                int num = n;

                while(set.contains(num+1)){
                    num++;
                    cnt++;
                }
                ans = Math.max(ans,cnt);
            }
        }
        return ans;
    }
}