package ds.pq;

import java.util.Arrays;

public class Heap {
    int count = 0;
    int capacity;
    int[] store;
    boolean isMaxHeap = false;

    /**
     * Max heap if param isMaxHeap is true, otherwise min-hip
     *
     * @param capacity  - capacity of the heap
     * @param isMaxHeap - true for max hip.
     */
    public Heap(int capacity, boolean isMaxHeap) {
        this.capacity = capacity;
        this.isMaxHeap = isMaxHeap;
        this.store = new int[capacity];
    }

    /**
     * Min heap
     *
     * @param capacity
     */
    public Heap(int capacity) {
        this.capacity = capacity;
        this.store = new int[capacity];
    }

    public void print() {
        if (store != null) {
            System.out.printf("%s Heap = \n", isMaxHeap ? "Max" : "Min");
            Arrays.stream(store).limit(count).forEach(System.out::println);
            System.out.println();
        }
    }

    private void resizeStore(int capacity) {
        int[] backupStore = store;
        store = new int[capacity];
        this.capacity = capacity;
        for (int i = 0; i < count; i++) {
            store[i] = backupStore[i];
        }
    }

    public void insert(int item) {
        if (capacity == count) {
            resizeStore(capacity * 2);
        }
        store[count++] = item;
        percolateUp(count - 1);
    }

    public void delete() {
        store[0] = store[--count];
        store[count] = -1;
        if (count % capacity == 0) {
            resizeStore(capacity / 2);
        }
        percolateDown(0);
    }

    public int findParent(int index) {
        int parentIndex = (index - 1) / 2;
        return parentIndex >= 0 && parentIndex < count ? parentIndex : -1;
    }

    public int findLeftChildren(int index) {
        int leftChildIndex = (index * 2) + 1;
        return leftChildIndex >= 0 && leftChildIndex < count ? leftChildIndex : -1;
    }

    public int findRightChildren(int index) {
        int rightChildIndex = (index * 2) + 2;
        return rightChildIndex >= 0 && rightChildIndex < count ? rightChildIndex : -1;
    }

    private void percolateDown(int targetIndex) {
        if (store != null) {
            if (targetIndex != -1) {
                int leftChildIndex = findLeftChildren(targetIndex);
                int rightChildIndex = findRightChildren(targetIndex);
                int maxIndex = targetIndex;
                if (leftChildIndex != -1 && ((isMaxHeap && store[leftChildIndex] > store[maxIndex]) ||
                        (!isMaxHeap && store[leftChildIndex] < store[maxIndex]))) {
                    maxIndex = leftChildIndex;
                } else if (rightChildIndex != -1 && (
                        (isMaxHeap && store[rightChildIndex] > store[maxIndex]) ||
                                (!isMaxHeap && store[rightChildIndex] < store[maxIndex])
                )) {
                    maxIndex = rightChildIndex;
                }

                if (maxIndex != targetIndex) {
                    int temp = store[maxIndex];
                    store[maxIndex] = store[targetIndex];
                    store[targetIndex] = temp;
                    percolateDown(maxIndex);
                }
            }
        }
    }

    private void percolateUp(int targetIndex) {
        if (store != null) {
            if (targetIndex != -1) {
                int parentIndex = findParent(targetIndex);
                if (parentIndex != -1 && (isMaxHeap && store[parentIndex] < store[targetIndex]) ||
                        (!isMaxHeap && store[parentIndex] > store[targetIndex])) {
                    int temp = store[parentIndex];
                    store[parentIndex] = store[targetIndex];
                    store[targetIndex] = temp;
                    percolateUp(parentIndex);
                }
            }
        }
    }

    private int search(int key) {
        int i = 0, j = count - 1;
        while (i < j) {
            if (store[i] == key) {
                return i;
            }
            if (store[j] == key) {
                return j;
            }
            i++;
            j--;
        }
        return -1;
    }

    public static void main(String[] args) {
        Heap maxHeap = new Heap(10, true);
        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(6);
        maxHeap.insert(1);
        maxHeap.insert(4);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.print();
        maxHeap.delete();
        maxHeap.print();
        Heap minHeap = new Heap(3);
        minHeap.insert(20);
        minHeap.insert(30);
        minHeap.insert(18);
        minHeap.insert(16);
        minHeap.insert(14);
        minHeap.insert(13);
        minHeap.insert(12);
        minHeap.print();
        minHeap.delete();
        minHeap.print();

    }
}
