package ds.linkedList;

public class MainTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(1, 2, 3, 4, 5, 6, 7);
        System.out.println(list);
        list.insertAtBeginning(0);
        list.insetAtEnd(8);
        System.out.println(list);
        list.removeAtBegin();
        list.removeAtEnd();
        System.out.println(list);
        System.out.println(list.findEndNthElement(2));
        System.out.println("Middle "+list.getMiddleOfList());
        LinkedList<Integer> list2 = new LinkedList<>(1);

        System.out.println(list2.findEndNthElement(2));
        System.out.println("Middle "+list2.getMiddleOfList());
    }
}
