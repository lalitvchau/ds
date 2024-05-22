package ds.stack;

public class PalindromeString {

    static boolean isPalindromeString(String string) {
        int length = string.length();
        if (length == 0) {
            return true;
        }
        StackLinkedList<Character> store = new StackLinkedList<>();
        for (int mid = length / 2; mid < length; mid++) {
            store.push(string.charAt(mid));
        }

        int i = 0;
        while (i < length / 2) {
            if (store.isEmpty() || store.pop() != string.charAt(i++)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeString("aba"));
        System.out.println(isPalindromeString("abcddcba"));
        System.out.println(isPalindromeString("abcd"));
    }
}
