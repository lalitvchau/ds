package ds.queue;

public class Queue<E> {

    private Node<E> front;
    private Node<E> rear;
    private int size = 0;


    public void enqueue(E value) {
        if (rear == null && front == null) {
            rear = front = new Node<>(value, null);
        } else {
            rear.next = new Node<>(value, null);
            rear = rear.next;
        }
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow Exception: Stack is empty");
        } else {
            E value = front.value;
            front = front.next;
            size--;
            if (isEmpty()) {
                rear = front;
            }
            return value;
        }
    }

    public boolean isNotEmpty() {
        return size > 0;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    int size() {
        return size;
    }

    @Override
    public String toString() {
        String result = "[";
        Node<E> current = front;
        while (current != null) {
            result = String.format("%s%s ", result, current.value);
            current = current.next;
        }
        return String.format("%s]", result);
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Queue<String> list = new Queue<>();
        System.out.println(list);
        System.out.println(list.isEmpty());

        list.enqueue("Yes");
        list.enqueue("Ram");
        System.out.println(list);
        System.out.println(list.dequeue());
        System.out.println(list.dequeue());
        System.out.println(list);
    }
}
