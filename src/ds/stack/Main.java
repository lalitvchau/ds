package ds.stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(1,2,3,4,5,6,7,8,9,10,11);
        System.out.println(stack);
        stack.push(12);
        stack.push(13);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        Stack<Integer> stack3 = new Stack<>(21,22,23,24,25,26,27,28,29,210,211);
        System.out.println(stack3);
        stack.addAll(stack3);
        System.out.println(stack);
    }
}
