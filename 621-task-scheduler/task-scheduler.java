class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : map.values()) {
            pq.add(freq);
        }

        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = 0;

            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    int curr = pq.poll();
                    if (curr > 1)
                        temp.add(curr - 1); // decrease task count
                    cycle++;
                } else {
                    if (temp.isEmpty()) break; // No more tasks to wait for
                    cycle++;
                }
            }

            // Reinsert remaining tasks
            for (int remaining : temp) {
                pq.add(remaining);
            }

            // Add time: either full cycle or actual time if last batch
            time += pq.isEmpty() ? cycle : (n + 1);
        }

        return time;
    }
}
