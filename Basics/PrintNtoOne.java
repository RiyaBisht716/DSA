package Basics;
import java.util.*;

public class PrintNtoOne {
    public static void printNtoOne(int i ,int n){
        if(i<1)return;
        System.out.println(i);
        printNtoOne(i-1,n);
        
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printNtoOne(n,n);
    }
    
}
