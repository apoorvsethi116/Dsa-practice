import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // Stores the smaller half
    private PriorityQueue<Integer> minHeap; // Stores the larger half

    public MedianFinder() {
        // Max-Heap needs Collections.reverseOrder() in Java
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: Always route through the max-heap first
        maxHeap.add(num);
        
        // Step 2: Ensure the ordering rule is maintained 
        // (Move the largest of the small half to the large half)
        minHeap.add(maxHeap.poll());
        
        // Step 3: Ensure the size rule is maintained 
        // We allow maxHeap to hold at most 1 extra element
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek(); // Odd number of elements
        }
        // Even number of elements: average the two middle peaks
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}