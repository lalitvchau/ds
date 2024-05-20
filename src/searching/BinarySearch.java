package searching;

public class BinarySearch {
    public static int binarySearch(int[] array, int key){
        return search(array,key,0,array.length);
    };

    private static int search(int[] array,int key, int start, int end){
        if(end<= start){
            return -1;
        }else{
            int mid = (start+end) /2;
            return array[mid]==key ? mid:array[mid]>key ? search(array,key,start,mid-1):search(array,key,mid+1,end);
        }
    }
}
