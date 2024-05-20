package leetCode;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        List<String> subString = new ArrayList<>();
        int count = 0;
        if (s == null) {
            return 0;
        }
        for (char itrChar : s.toCharArray()) {
            int index = subString.indexOf("" + itrChar);
            if (index >= 0) {
                if (count < subString.size()) {
                    count = subString.size();
                }
                for (int i = 0; i <= index; i++) {
                    subString.remove(0);
                }
            }
            subString.add("" + itrChar);
        }
        return subString.size() > count ? subString.size() : count;
        // abc
    }

    public static int lengthOfLongestSubstringUsingSet(String s) {
        int maxLength = 0;
        Set<Character> charcterSet = new HashSet<>();
        int left = 0;
        for (char ch : s.toCharArray()) {
            while (charcterSet.contains(ch)) {
                charcterSet.remove(s.charAt(left++));
            }
            charcterSet.add(ch);
            maxLength = Math.max(maxLength, charcterSet.size());
        }
        return maxLength;
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        if(nums1Length<=0&&nums2Length<=0){
            return 0;
        }
        int[] mergedArray = new int[nums1Length + nums2Length];
        int nums1Itr = 0, nums2Itr = 0;
        for (int i = 0; i < mergedArray.length; i++) {
            if (nums1Itr >= nums1Length) {
                while (nums2Itr < nums2Length) {
                    mergedArray[i++] = nums2[nums2Itr++];
                }
            } else if (nums2Itr >= nums2Length) {
                while (nums1Itr < nums1Length) {
                    mergedArray[i++] = nums1[nums1Itr++];
                }
            } else {
                if (nums1[nums1Itr] < nums2[nums2Itr]) {
                    mergedArray[i] = nums1[nums1Itr++];
                } else {
                    mergedArray[i] = nums2[nums2Itr++];
                }
            }
        }

        int mid = mergedArray.length/2;
        if( mergedArray.length%2==0){
            return (mergedArray[mid]+mergedArray[mid-1])/2.0;
        }
        else{
            return mergedArray[mid];
        }
    }

        public static void main (String[]args){
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//            System.out.println(lengthOfLongestSubstringUsingSet("pwwkew"));
            System.out.println(findMedianSortedArrays(new int[]{},new int[]{1}));
        }
    }
