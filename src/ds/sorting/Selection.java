package ds.sorting;

public class Selection {

    public static int[] sort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[min] > list[j]) {
                    min = j;
                }
            }
            if (min != i) {
                list[min] = list[i] + list[min];
                list[i] = list[min] - list[i];
                list[min] = list[min] - list[i];
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int numbers[] = {23, 56, 32, 12, 6, 4, 2};
        for (int itr : sort(numbers)) {
            System.out.printf("%s ", itr);
        }
        System.out.println();
    }
}
