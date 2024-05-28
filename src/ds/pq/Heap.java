package ds.pq;

import java.util.Arrays;

public class Heap {
    int count = 0;
    int capacity;
    Node[] store;
    boolean isMaxHeap = false;

    public static class Node {
        int key;
        int weight;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Node(int key, int weight) {
            this.key = key;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("[ key=%d: weight=%d]", key, weight);
        }
    }

    /**
     * Max heap if param isMaxHeap is true, otherwise min-hip
     *
     * @param capacity  - capacity of the heap
     * @param isMaxHeap - true for max hip.
     */
    public Heap(int capacity, boolean isMaxHeap) {
        this.capacity = capacity;
        this.isMaxHeap = isMaxHeap;
        this.store = new Node[capacity];
    }

    /**
     * Min heap
     *
     * @param capacity
     */
    public Heap(int capacity) {
        this.capacity = capacity;
        this.store = new Node[capacity];
    }

    public void print() {
        if (store != null) {
            System.out.printf("%s Heap = \n", isMaxHeap ? "Max" : "Min");
            Arrays.stream(store).limit(count).forEach(System.out::println);
            System.out.println();
        }
    }

    private void resizeStore(int capacity) {
        Node[] backupStore = store;
        store = new Node[capacity];
        this.capacity = capacity;
        for (int i = 0; i < count; i++) {
            store[i] = backupStore[i];
        }
    }

    public void insert(int key, int weight) {
        if (capacity == count) {
            resizeStore(capacity * 2);
        }
        store[count++] = new Node(key, weight);
        percolateUp(count - 1);
    }

    public void insert(Node node) {
        if (capacity == count) {
            resizeStore(capacity * 2);
        }
        store[count++] = node;
        percolateUp(count - 1);
    }

    public Node delete() {
        Node deletedItem = store[0];
        store[0] = store[--count];
        store[count] = null;
        if (count > 0 && count % capacity == 0) {
            resizeStore(capacity / 2);
        }
        percolateDown(0);
        return deletedItem;
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
                if (leftChildIndex != -1 && ((isMaxHeap && store[leftChildIndex].weight > store[maxIndex].weight) ||
                        (!isMaxHeap && store[leftChildIndex].weight < store[maxIndex].weight))) {
                    maxIndex = leftChildIndex;
                } else if (rightChildIndex != -1 && (
                        (isMaxHeap && store[rightChildIndex].weight > store[maxIndex].weight) ||
                                (!isMaxHeap && store[rightChildIndex].weight < store[maxIndex].weight)
                )) {
                    maxIndex = rightChildIndex;
                }

                if (maxIndex != targetIndex) {
                    Node temp = store[maxIndex];
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
                if (parentIndex != -1 && (isMaxHeap && store[parentIndex].weight < store[targetIndex].weight) ||
                        (!isMaxHeap && store[parentIndex].weight > store[targetIndex].weight)) {
                    Node temp = store[parentIndex];
                    store[parentIndex] = store[targetIndex];
                    store[targetIndex] = temp;
                    percolateUp(parentIndex);
                }
            }
        }
    }

    private int search(int weight) {
        int i = 0, j = count - 1;
        while (i < j) {
            if (store[i].weight == weight) {
                return i;
            }
            if (store[j].weight == weight) {
                return j;
            }
            i++;
            j--;
        }
        return -1;
    }

    public boolean isEmpty() {
        return count <= 0;
    }

    public boolean isNotEmpty() {
        return count > 0;
    }

    public static void main(String[] args) {
        Heap maxHeap = new Heap(10, true);
        maxHeap.insert(0, 7);
        maxHeap.insert(1, 5);
        maxHeap.insert(2, 6);
        maxHeap.insert(3, 1);
        maxHeap.insert(4, 4);
        maxHeap.insert(5, 2);
        maxHeap.insert(6, 3);
        maxHeap.insert(7, 17);
        maxHeap.print();
        maxHeap.delete();
        maxHeap.print();
        Heap minHeap = new Heap(3);
        minHeap.insert(1, 20);
        minHeap.insert(2, 30);
        minHeap.insert(3, 18);
        minHeap.insert(4, 16);
        minHeap.insert(5, 14);
        minHeap.insert(6, 13);
        minHeap.insert(7, 12);
        minHeap.print();
        minHeap.delete();
        minHeap.print();

    }
}
