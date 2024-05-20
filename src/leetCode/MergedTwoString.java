package leetCode;

public class MergedTwoString {
    public static void main(String[] args) {

    }

    public String mergeAlternately2(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int word1Length = word1.length();
        int word2Length = word2.length();
        int minLength = Math.min(word1Length, word2Length);
        for (int i = 0; i < minLength; i++) {
            stringBuilder.append(word1.charAt(i)).append(word2.charAt(i));
        }
        stringBuilder.append(word1.substring(minLength)).append(word2.substring(minLength));
        return stringBuilder.toString();
    }

    public String mergeAlternately(String word1, String word2) {
        if (word1 != null & word2 != null) {
            StringBuilder result = new StringBuilder();
            int word2Itr = 0;
            for (int itr = 0; itr < word1.length(); itr++) {
                result.append(word1.charAt(itr));
                try {
                    result.append(word2.charAt(word2Itr++));
                } catch (IndexOutOfBoundsException e) {
                    result.append(word1.substring(itr + 1));
                    break;
                }
            }
            if (word2.length() > word2Itr) {
                result.append(word2.substring(word2Itr));
            }
            return result.toString();
        } else if (word2 == null) {
            return word1;
        } else {
            return word2;
        }
    }
}
