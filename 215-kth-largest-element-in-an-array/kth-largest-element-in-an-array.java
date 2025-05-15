class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int a: nums) pq.add(a);

        while(k-1>0){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}