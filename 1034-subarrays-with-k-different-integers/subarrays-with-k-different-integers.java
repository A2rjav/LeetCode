class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums,k) - atMostK(nums,k-1);
    }
    public int atMostK(int []nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();

        int i =0,j=0,c=0;
        while( j< nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0) +1);
            
            while(map.size() > k){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }
            // if(map.size() == k){
            //     c++;
            // }
            c+= j-i+1;
            j++;
        }
        return c;
    }
}