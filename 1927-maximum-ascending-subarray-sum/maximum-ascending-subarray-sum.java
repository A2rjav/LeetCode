class Solution {
    public int maxAscendingSum(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                list.add(list.get(i-1)+nums[i]);
            }else{
                list.add(nums[i]);
            }
        }
        return Collections.max(list);
    }
}