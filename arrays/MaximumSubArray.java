package arrays;
import java.util.*;

public class MaximumSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n]; 

        //read elements from an array
        for(int i=0 ;i<n;i++){
            arr[i] = sc.nextInt();
        }


        //kadane's algorithm

        int maxSoFar = arr[0];
        int currMax = arr[0];

        for(int i= 1; i< n;i++){
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
            
        }
        System.out.println(maxSoFar);

    }
    
}
