package arrays;

import java.util.Arrays;


public class Swap {
    public static void main(String[] args) {
        int [] arr = {1,25,6,7,8};
        swap(arr,0,4);//starting index and last index

        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr,int index1, int index2){
        int temp = index1;
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }
    
}
