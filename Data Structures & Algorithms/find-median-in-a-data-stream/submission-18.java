/* 
if its less than the max heap, put it in the first, otherwise, put it in the second
can be balance by up to 1, if its its up to 2, then move to the other
*/

class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b -a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size() && minHeap.size() == 0) {
            maxHeap.add(num);
        }
        else if (num < maxHeap.peek()) {
            maxHeap.add(num);
        }
        else {
            minHeap.add(num);
        }
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        }
        else if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else {
            if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            }
            else {
                return maxHeap.peek();
            }
        }
    }
}
