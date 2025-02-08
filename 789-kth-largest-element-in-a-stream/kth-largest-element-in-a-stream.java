import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> pq;
    private int K;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        K = k;

        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        pq.add(val);

        if (pq.size() > K) {
            pq.poll();
        }

        return pq.peek();
    }
}
