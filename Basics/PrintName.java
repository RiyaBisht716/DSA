package Basics;
import java.util.*;
public class PrintName {


    public static void printName(String name,int i ,int num){
        if(i>num)
        return;
        System.out.println(name);
        printName(name,i+1,num);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name:");
        String name = sc.nextLine();

        System.out.println("Enter the number:");
        int num = sc.nextInt();

        printName(name,1,num);




        
    }
}
