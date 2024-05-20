package leetCode;

import java.util.ArrayList;
import java.util.List;

public class GCDString {
    public static void main(String[] args) {
        System.out.println(gcd(4, 6));
        System.out.println(gcd(15, 20));
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if ((str1 + str2).equals(str2 + str1)) {
            return str1.length() > str2.length() ? str1.substring(0, gcd(str1.length(), str2.length())) : str2.substring(0, gcd(str1.length(), str2.length()));
        }
        return "";
    }

    public static int gcd(int num1, int num2) {
        return num2 == 0 ? num1 : gcd(num2, num1 % num2);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> candiesWithLargest = new ArrayList<>();
        int maxCandies = 0;
        for(int candy:candies){
            if(maxCandies<candy){
               maxCandies=candy;
            }
        }
        for(int candy:candies){
            candiesWithLargest.add(candy+extraCandies>=maxCandies);
        }

        return candiesWithLargest;
    }
}
