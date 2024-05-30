package ds.sorting;

public class QuickSort {

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = findPartition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }

    private static int findPartition(int[] array, int left, int right) {
        int currentPivot = left;
        while (left < right) {
            while (array[currentPivot] > array[left]) {
                left++;
            }
            while (array[currentPivot] < array[right]) {
                right--;
            }
            if (left < right) {
                array[left] += array[right];
                array[right] = array[left] - array[right];
                array[left] -= array[right];
            }
        }
        array[currentPivot] = array[right];
        array[right] = array[currentPivot];
        return right;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 9, 1, 67, 32, 0, -2};
        quickSort(numbers);
        for (int number : numbers) {
            System.out.printf("%d ", number);
        }
        System.out.println();
    }
}
