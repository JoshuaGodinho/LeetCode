class Solution {
    private int[] heap;
    private int size;
    public int findKthLargest(int[] nums, int k) {
        heap = new int[k];
        size = 0;
        for(int num:nums)
            insert(num);

        return getMin();
    }

    public void insert(int value){
        if(size<heap.length){
            heap[size]=value;
            bubbleup(size);
            size++;
        }else if(value>heap[0]){
            heap[0]=value;
            bubbleDown(0);
        }
    }

    private void bubbleup(int index){
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap[index] < heap[parentIndex]) {
                // Swap
                int temp = heap[index];
                heap[index] = heap[parentIndex];
                heap[parentIndex] = temp;
                index = parentIndex;
            } else {
                break;
            }
        }
    }
    private void bubbleDown(int index) {
        while (index < size) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallestIndex = index;

            if (leftChildIndex < size && heap[leftChildIndex] < heap[smallestIndex]) {
                smallestIndex = leftChildIndex;
            }

            if (rightChildIndex < size && heap[rightChildIndex] < heap[smallestIndex]) {
                smallestIndex = rightChildIndex;
            }

            if (smallestIndex != index) {
                // Swap
                int temp = heap[index];
                heap[index] = heap[smallestIndex];
                heap[smallestIndex] = temp;
                index = smallestIndex;
            } else {
                break;
            }
        }
    }
   
    public int getMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }
}