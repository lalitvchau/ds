package ds;

import java.util.Arrays;

public class BacktrackingNString {
    static int[] array= new int[5];
    static int[] array2= new int[5];

    public static void main(String[] args) {
        nStirng(4);
        System.out.println("=_=_+-=");
        nKStirng(2,3);
    }

    static void nStirng(int n){
        if(n<1){
            System.out.println(Arrays.toString(array));
        }else{
            array[n-1]=0;
            nStirng(n-1);
            array[n-1]=1;
            nStirng(n-1);
        }
    }

    static void nKStirng(int n,int k){
        if(n<1){
            System.out.println(Arrays.toString(array2));
        }else{
            for(int j=0;j<k;j++) {
                array2[n - 1] = j;
                nKStirng(n - 1, k);
            }
        }
    }

}
