class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums,k) - atMostK(nums,k-1);
    }

    public int atMostK(int []nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int n = nums.length;
        for(int l=0,r=0;r<n;r++){
            int right = nums[r];
            map.put(right,map.getOrDefault(right,0)+1);

            while(map.size() > k){
                int left = nums[l];
                map.put(left,map.get(left)-1);
                if(map.get(left) == 0) map.remove(left);
                l++;
            }

            count += (r-l+1);
        }
        return count;
    }
}