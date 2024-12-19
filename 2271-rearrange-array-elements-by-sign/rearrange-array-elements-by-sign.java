class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos =0;
        int neg =1;
        int arr[] = new int[nums.length];
        for(int num : nums){
            if(num >=0){
                arr[pos] = num;
                pos+=2;
            }else{
                arr[neg] = num;
                neg +=2;
            }
        }
        return arr;
    }
}