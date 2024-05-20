package searching;

public class SeqSearch {
    public static int linearSearch(int[] array, int key){
        for(int i=0;i<array.length;i++){
            if(array[i]== key){
                return i;
            }
        }
        return -1;
    }

    public static int linearSearchR(int[] array, int key){
        return search(array,key,0);
    }

    private static int search(int[] array, int key, int i){
        if(i<array.length){
            if(array[i]==key) return i;
            return search(array,key,i+1);
        } else {
            return -1;
        }
    }
}
