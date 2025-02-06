class Solution {
    class Pair implements Comparable<Pair> {
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        public int compareTo(Pair p2) {
            return this.freq - p2.freq; 
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        for (int key : map.keySet()) {
            pq.add(new Pair(key, map.get(key)));
            if (pq.size() > k) {
                pq.poll(); 
            }
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll().num; 
        }
        return ans;
    }
}
