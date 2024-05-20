package ds.linkedList;

public class LinkedList<T> {

    private int length = 0;
    private Node<T> head = null;

    public LinkedList() {
        head = new Node<>(null, null);
    }

    @SafeVarargs
    public LinkedList(T... values) {
        head = new Node<>(null, null);
        if (values != null && values.length > 0) {
            head.value = values[length++];
            Node<T> current = head;
            while (length < values.length) {
                current.next = new Node<T>(values[length++], null);
                current = current.next;
            }
        }
    }

    public void insertAtBeginning(T value) {
        Node<T> current = head;
        head = new Node<T>(value, current);
        length++;
    }

    public void insetAtEnd(T value) {
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<T>(value, null);
        length++;
    }

    public void removeAtBegin() {
        Node<T> current = head;
        if (head.next == null) {
            head.value = null;
        } else {
            head = head.next;
        }
        length--;
    }

    public void removeAtEnd() {
        Node<T> current = head;
        if (head.next == null) {
            head.value = null;
        } else {
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        length--;
    }

    public T findEndNthElement(int offsetFromEnd) {
        if (offsetFromEnd >= length) {
            return (T) head.value;
        }else{
            Node<T> current = head;
            int diff = length - offsetFromEnd;
            while(diff-->0){
                current=current.next;
            }
            return (T) current.value;
        }
    }

    public T findEndNthElementWithoutLength(int offsetFromEnd) {
        Node<T> fastPointer = head;
        Node<T> slowPointer= head;
        while(offsetFromEnd-->0){
            fastPointer=fastPointer.next;
        }
        while(fastPointer.next!=null){
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next;
        }
        if(offsetFromEnd==0){
            return slowPointer.value;
        }else{
            throw new RuntimeException("Offset is invalid");
        }
    }

    @Override
    public String toString() {
        if (length > 0) {
            String result = "head";
            Node<T> current = head;
            while (current != null) {
                result =String.format("%s-->[%s]", result,current.value);
                current = current.next;
            }
            return result;
        } else {
            return "Empty";
        }
    }

     private static class Node<T> {
        private Node<T> next;
        private T value;

        public Node(T value, Node<T> next) {
            this.next = next;
            this.value = value;
        }
    }

}
