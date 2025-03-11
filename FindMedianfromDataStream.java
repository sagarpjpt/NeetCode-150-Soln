class MedianFinder {

    //maxheap for the smaller half ie [1 2 3 4 5 6 7 8] so maxheap stores [1 2 3 4]
    private PriorityQueue<Integer> max_heap;
    //min heap will store [5 6 7 8]
    private PriorityQueue<Integer> min_heap;

    public MedianFinder() {
        
        max_heap = new PriorityQueue<>((a, b) -> b-a);//lembda exp
        min_heap = new PriorityQueue<>();

    }
    
    public void addNum(int num) {
        
        if(max_heap.isEmpty() || num <= max_heap.peek())
            max_heap.offer(num);
        else
            min_heap.offer(num);

        //need to balance heap with atmost 1 extra ele allow in maxheap

        if(max_heap.size() > min_heap.size() + 1)
            min_heap.offer(max_heap.poll());
        else if(min_heap.size() > max_heap.size())
            max_heap.offer(min_heap.poll());
    }
    
    public double findMedian() {

        //if size of array odd
        if(max_heap.size() > min_heap.size())
            return max_heap.peek();
        //size of array even
        else
            return (max_heap.peek() + min_heap.peek()) / (double)2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
