class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // Left half (smaller numbers)
    private PriorityQueue<Integer> minHeap; // Right half (larger numbers)

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max-Heap
        minHeap = new PriorityQueue<>(); // Min-Heap
    }

    public void addNum(int num) {
        // Step 1: Add to maxHeap (left half)
        maxHeap.offer(num);

        // Step 2: Balance - Ensure maxHeap's top is smaller than minHeap's top
        minHeap.offer(maxHeap.poll());

        // Step 3: Maintain size balance - maxHeap should have more or equal elements
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek(); // Odd count, median is top of maxHeap
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0; // Even count, avg of tops
    }
}
