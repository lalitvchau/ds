package ds.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int itr = left;
        int leftArray[] = Arrays.copyOfRange(array, left, mid + 1);
        int rightArray[] = Arrays.copyOfRange(array, mid + 1, right + 1);
        int leftArrayPointer = 0;
        int rightArrayPointer = 0;

        while (leftArrayPointer < leftArray.length && rightArrayPointer < rightArray.length) {
            if (leftArray[leftArrayPointer] < rightArray[rightArrayPointer]) {
                array[itr++] = leftArray[leftArrayPointer++];
            } else {
                array[itr++] = rightArray[rightArrayPointer++];
            }
        }

        while (leftArrayPointer < leftArray.length) {
            array[itr++] = leftArray[leftArrayPointer++];
        }
        while (rightArrayPointer < rightArray.length) {
            array[itr++] = rightArray[rightArrayPointer++];
        }
    }

    public static void main(String[] args) {
        int list[] = {3, 2, 4, 1, 4, 6, 9, -1, 5, 4, -3, 6, 7, 3};
        sort(list);
        for (int item : list) {
            System.out.printf(" %d", item);
        }
    }
}
