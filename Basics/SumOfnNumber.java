//import java.util.*;
public class SumOfnNumber {
    // public static void printSumOfnNumber(int i,int sum){
    //     if(i<1){
    //         System.out.println(sum);
    //         return;

    //     }
    //     printSumOfnNumber(i-1,sum+i);
    // }
    public static int sum(int n){
        if(n==0)
        return 0;
        return n + sum(n-1);


    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // printSumOfnNumber(n,0);
        int n =5;
        System.out.println("Sum of first " + n + " numbers = "  + sum(n) );

        
    }
    

}
