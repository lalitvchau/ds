package ds.queue;

public class Queue<T> {
    T[] store;
    int capacity = 4;
    int size = 0;
    int front = 0, rear = -1;

    Queue() {
        store = (T[]) new Object[capacity];
    }

    Queue(int capacity) {
        store = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    void enqueue(T value) {
        if (rear != (front - 1) % (capacity - 1)) {
            rear %= capacity;
            store[rear] = value;
            size++;
        } else {
            throw new RuntimeException("Queue is full");
        }
    }

    T dequeue() {
        if (rear <= front) {
            size--;
            front %= capacity;
            return store[front];
        } else {
            throw new RuntimeException("Queue is empty");
        }
    }

    int size() {
        return size;
    }

    @Override
    public String toString() {
        String result = "[";
        int tempFront = front;
        while (tempFront < rear && store[tempFront] != null) {
            result = String.format("%s%s", result, store[tempFront]);
            tempFront = tempFront % capacity - 1;
        }
        return String.format("%s]", result);
    }

    public static void main(String[] args) {
        Queue<Integer> integerQueue = new Queue<>();
        integerQueue.enqueue(12);
        System.out.println(integerQueue);
    }
}
