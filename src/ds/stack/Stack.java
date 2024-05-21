package ds.stack;

public class Stack<T> {
    int maxSize = 12;
    T[] store;

    int top = -1;

    Stack() {
        store = (T[]) new Object[maxSize];
    }

    Stack(T... args) {
        maxSize *= args.length / 12;
        if (maxSize == 0) {
            maxSize = 12;
        }
        store = (T[]) new Object[maxSize];
        for (int i = 0; i < args.length; i++) {
            store[i] = args[i];
        }
        top = args.length - 1;
    }

    void push(T value) {
        if ((top + 1) % maxSize == 0) {
            shift(maxSize * 2);
        }
        store[++top] = value;
    }

    T pop() {
        T returnItem = store[top];
        if (top-- % (maxSize / 2) == 0) {
            shift(maxSize / 2);
        }
        return returnItem;
    }

    T[] toArray() {
        return store;
    }

    void addAll(Stack<T> stack){
        for(T item:stack.toArray()){
            push(item);
        }
    }

    T peek() {
        return top > -1 ? store[top] : null;
    }

    boolean isEmpty() {
        return top < 0;
    }

    private void shift(int maxSize) {
        this.maxSize = maxSize;
        T[] temp = store;
        store = (T[]) new Object[maxSize];
        int i = top;
        while (i >= 0) {
            store[i] = temp[i];
            i--;
        }
    }

    @Override
    public String toString() {
        String result = "[";
        for (T item : store) {
            result = String.format("%s%s ", result, item != null ? item : "");
        }
        return String.format("%s]", result);
    }
}
