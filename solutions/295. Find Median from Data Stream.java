class MedianFinder 
{
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1, e2) -> (e2 - e1)); 
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 

    /** initialize your data structure here. */
    public MedianFinder(){}
    
    public void addNum(int num) 
    {
        if (maxHeap.size() == 0)
            maxHeap.add(num);
        else if (maxHeap.peek() >= num) 
        {
            maxHeap.add(num);
            balance();
        } 
        else 
        {
            minHeap.add(num);
             balance();
        }
    }
    
    public double findMedian() 
    {
        if ((maxHeap.size() + minHeap.size()) % 2 == 0)
            return (maxHeap.peek() + 0.0 + minHeap.peek()) / 2;
        else if (maxHeap.size() > minHeap.size()) 
            return maxHeap.peek();
        else 
            return minHeap.peek();
    }
    
    private void balance() 
    {
        if (maxHeap.size() > minHeap.size() + 1) 
            minHeap.add(maxHeap.poll());
        else if (minHeap.size() > maxHeap.size() + 1) 
            maxHeap.add(minHeap.poll());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */