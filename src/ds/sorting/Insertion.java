package ds.sorting;

public class Insertion {
    public static int[] sort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int selected = list[i];
            int j = i;
            while (j > 0 && list[j - 1] > selected) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = selected;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] list = {4, 5, 1, 2, 3, 2, 6, 7, 5, 4, 3, 7, 5, 9, 0, 8, 7, 5, 8, 4, 2, 7, 5};
        for (int item : sort(list)) {
            System.out.printf(" %d", item);
        }
    }
}
