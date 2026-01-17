package arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        //Syntax
        ArrayList<Integer> list = new ArrayList<>(10);
        // list.add(34);
        // list.add(45);
        // list.add(14);
        // list.add(12);

       

    // System.out.println(list.contains(12)); //It will give me true or false
    // list.set(0,64);
    // list.remove(1);
    // System.out.println(list);

      

    //input
    for(int i= 0 ; i< 5; i++){
        list.add(sc.nextInt());
    }

    //get item at any index
    for(int i = 0; i < 5 ;i++){
        System.out.println(list.get(i));//pass index here, list[index] syntax will not work here
    }

    System.out.println(list);
    }
    
}
  