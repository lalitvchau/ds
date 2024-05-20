package leetCode;

import java.util.Arrays;

public class ArrayQues {
    public static void main(String[] args) {
        for (int num : productExceptSelf(new int[]{1, 2, 3, 4})) {
            System.out.println(num);
        }

    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answers = new int[length];
        int current = 1;
        for (int i = 0; i < length; i++) {
            answers[i] = current;
            current *= nums[i];
        }
        current = 1;
        for (int i = length - 1; i >= 0; i--) {
            answers[i] *= current;
            current *= nums[i];
        }
        return answers;
    }
}

