class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        } 
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair arr[] = new Pair[n];

        for(int i=0;i<n;i++){
            arr[i]= new Pair(nums1[i],nums2[i]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(arr,(b,a)-> a.second-b.second);

        long sum = 0;
        for(int i=0;i<k;i++){
            pq.add(arr[i].first);
            sum += arr[i].first;
        }
        long result = sum * arr[k-1].second;
        
        for(int i=k;i<n;i++){
            sum += arr[i].first - pq.peek();
            pq.poll();
            pq.add(arr[i].first);
            result = Math.max(result,sum*arr[i].second);
        }
        return result;

    }
}