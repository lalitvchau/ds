package ds.sorting;

public class BubbleSort {
    public static int[] sort(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Number should not be null");
        }
        boolean needToSort = true;
        for (int i = numbers.length - 1; i >= 0 && needToSort; i--) {
            needToSort = false;
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    numbers[j] = numbers[j] + numbers[j + 1];
                    numbers[j + 1] = numbers[j] - numbers[j + 1];
                    numbers[j] = numbers[j] - numbers[j + 1];
                    needToSort = true;
                }
            }
        }
        return numbers;
    }

    public static void main(String... args) {
        int[] numbers = {3, 2, 8, 5, 3, 8, 4, 2, 1, 9};
        for (int number : numbers) {
            System.out.printf(" %d", number);
        }
        System.out.println("\nAfter sort");
        for (int number : sort(numbers)) {
            System.out.printf(" %d", number);
        }
        System.out.println();
    }
}
