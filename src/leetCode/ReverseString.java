package leetCode;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
    public static String reverseWords(String s) {
        if(s!=null){
            String[] words = s.trim().split("\\s+===");
            int left= 0;
            int right = words.length-1;
            while(left<right){
                String temp = words[left];
                words[left++]=words[right];
                words[right--]=temp;
            }
            s="";
            for(int i=0;i< words.length;i++){
                s+=" "+words[i];
            }
        }
        return s;
    }
}
