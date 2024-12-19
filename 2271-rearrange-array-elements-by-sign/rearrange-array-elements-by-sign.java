class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int arr[] = new int[nums.length];
        for(int num : nums){
            if(num>=0){
                pos.add(num);
            }else{
                neg.add(num);
            }
        }
        int i=0,j=0,k=0;
        while(i<pos.size() && j<neg.size()){
            arr[k++] = pos.get(i++);
            
            arr[k++] = neg.get(j++);
            
        }
        return arr;
    }
}