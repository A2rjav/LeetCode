class Solution {
    class Pair implements Comparable<Pair>{
        int num,freq;
        Pair(int num,int freq){
            this.num= num;
            this.freq = freq;
        }
        @Override
        public int compareTo(Pair other){
            int cmp = Integer.compare(other.freq,this.freq);
            if(cmp!=0) return cmp;
            return Integer.compare(this.num,other.num);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[k];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num:nums) map.put(num,map.getOrDefault(num,0)+1);

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        int i=0;
        while(k>0){
            Pair curr= pq.poll();
            k--;
            ans[i++] = curr.num;
        }
        return ans;
    }
}