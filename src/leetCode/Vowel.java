package leetCode;

public class Vowel {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

    public static String reverseVowels(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        if (s != null) {
            int endPointer = stringBuilder.length() - 1;
            int beginPointer = 0;
            while (beginPointer < endPointer) {
                char beginChar = stringBuilder.charAt(beginPointer);
                char endChar = stringBuilder.charAt(endPointer);
                if (isVowel(beginChar) && isVowel(endChar)) {
                    stringBuilder.setCharAt(beginPointer++, endChar);
                    stringBuilder.setCharAt(endPointer--, beginChar);
                } else {
                    if (!isVowel(beginChar)) {
                        beginPointer++;
                    }
                    if (!isVowel(endChar)) {
                        endPointer--;
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    public static boolean isVowel(char ch) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }
}
