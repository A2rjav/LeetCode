class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() > num) 
        maxHeap.add(num);
        else
        minHeap.add(num);

        if(maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.peek());
            maxHeap.poll();
        }
        else if(minHeap.size()>maxHeap.size()){
            maxHeap.add(minHeap.peek());
            minHeap.poll();
        }
        
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (double) (maxHeap.peek() + minHeap.peek())/2.0;
        }
        else
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */