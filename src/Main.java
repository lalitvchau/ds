import searching.BinarySearch;
import searching.SeqSearch;

public class Main {
    public static void main(String[] args) {
        System.out.println("Linear Search");
        System.out.println(SeqSearch.linearSearchR(new int[]{2,6,7,3,2,5},5));
        System.out.println("Binary Search");
        System.out.println(BinarySearch.binarySearch(new int[]{2,6,7,10,12,15},15));
        System.out.println(BinarySearch.binarySearch(new int[]{115},115));
    }
}