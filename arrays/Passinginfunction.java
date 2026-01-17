package arrays;

import java.util.Arrays;

public class Passinginfunction {
    public static void main(String[] args) {
        int[ ] nums = {1,3,6,7};
        System.out.println(Arrays.toString(nums));
        change(nums);
        System.out.print(Arrays.toString(nums));


        
    }
    static void change(int[] arr){
        arr[1] = 66;
    } 
    
}
