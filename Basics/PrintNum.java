package Basics;
import java.util.*;
public class PrintNum {
    public static void printNum(int i,int n){
        // if(i> n)
        // return;
        // System.out.println(i);
        // printNum(i+1,n);
        //By using Backtracking
        if(i<1)return;
        printNum(i-1,n);
        System.out.println(i);
        

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the n: ");
        int n  = sc.nextInt();
        //printNum(1,n);
        printNum(n,n);

    }
    
}
