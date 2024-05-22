package ds.stack;

public class StackLinkedList<E> {

    private Node<E> top;
    private int size = 0;

    void push(E value) {
        top = new Node<>(value, top);
        size++;
    }

    E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow Exception: Stack is empty");
        } else {
            E value = top.value;
            top = top.next;
            size--;
            return value;
        }
    }

    boolean isEmpty() {
        return top == null;
    }

    int size() {
        return size;
    }

    E top() {
        return top == null ? null : top.value;
    }

    @Override
    public String toString() {
        String result = "[";
        Node<E> current = top;
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
        StackLinkedList<String> list = new StackLinkedList<>();
        System.out.println(list);
        System.out.println(list.isEmpty());

        list.push("Yes");
        list.push("Ram");
        System.out.println(list);
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list);
    }
}
