package ds.linkedList;

public class CircularListProblems<T> {
    Node<T> head = new Node<>(null, null);
    int length = 0;

    {
        head.next = head;
    }

    @SafeVarargs
    public CircularListProblems(T... values) {
        if (values != null && values.length > 0) {
            head.value = values[length++];
            Node<T> current = head;
            while (length < values.length) {
                current.next = new Node<T>(values[length++], head);
                current = current.next;
            }
        }
    }

    @Override
    public String toString() {
        if (length > 0) {
            String result = "head";
            Node<T> current = head;
            for (int i = 0; i < length; i++) {
                result = String.format("%s-->[%s]", result, current.value);
                current = current.next;
            }
            return String.format("%s-->head", result);
        } else {
            return "Empty";
        }
    }

    boolean isContainCircular(CircularListProblems<T> list2) {
        Node<T> fastPointer = head;
        Node<T> slowPointer = list2.head;
        if (fastPointer == null || slowPointer == null) {
            return false;
        } else {
            while (fastPointer != slowPointer) {
                if (fastPointer.next == null || slowPointer.next == null) {
                    return false;
                } else {
                    fastPointer = fastPointer.next.next;
                    slowPointer = slowPointer.next;
                }
            }
            return true;
        }
    }

    public Node<T> getLastNode() {
        Node<T> current = head;
        for (int i = 0; i < length - 1; i++) {
            current = current.next;
        }
        return current;
    }

    public static void main(String[] args) {
        CircularListProblems<Integer> list = new CircularListProblems<>(1, 2, 3, 4, 5, 6);
        System.out.println(list);

        CircularListProblems<Integer> list2 = new CircularListProblems<>(11, 12, 13);
        CircularListProblems<Integer> circle = new CircularListProblems<>(21, 22, 23, 24, 25, 26);
        Node<Integer> lastNodeOfList2 = list2.getLastNode();
        lastNodeOfList2.next = circle.head;
        list2.length += circle.length;

        Node<Integer> lastNodeOfList = list.getLastNode();
        list.length += circle.length;
        lastNodeOfList.next = circle.head;

        System.out.println(list);
        System.out.println(list2);
        System.out.println(list.isContainCircular(list2));

        CircularListProblems<Integer> newList = new CircularListProblems<>(12);
        newList.getLastNode().next = null;
        System.out.println(list.isContainCircular(newList));
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.next = next;
            this.value = value;
        }
    }
}
