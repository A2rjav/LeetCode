class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int arr[] = new int[nums.length];
        int n = arr.length;
        for(int i=2*n-1;i>=0;i--){
            while(!s.isEmpty() && nums[i%n]>=s.peek()){
                s.pop();
            }
                if(s.isEmpty()){
                    arr[i%n] = -1;
                }else{
                    arr[i%n] = s.peek();
                }
                s.push(nums[i%n]);
            }
        return arr;
    }
}