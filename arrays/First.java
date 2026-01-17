package arrays;
import java.util.Arrays;
import java.util.Scanner;
public class First {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //array of primitives 
        int [] arr = new int [5];
        arr[0] = 56;
        arr[1] = 66;
        arr[2] = 58;
        arr[3] = 96;
        arr[4] = 786;
        //[56,66,58,96,786]
        System.out.println(arr[3]);

        //input using for loops
    //  for(int i=0;i< arr.length; i++){
    //     arr[i] =sc.nextInt();

       // } 
        // for(int i=0; i<arr.length; i++){
        //     System.out.print(arr[i] + " ");
 
        // }

        //enhanced for loop

        // for(int num: arr){ //for every element in array ,print the element
        //     System.out.print(num + " ");//here num represents element of the array

        //}

        //array of objects

        String [] str = new String[4];
        for(int i=0; i< str.length ;i++){
            str[i] = sc.next();

        }
        System.out.print(Arrays.toString(str));
        
        //modify

        str[2] = "Riya";
        System.out.print(Arrays.toString(str));
        
        
    }
    
}
