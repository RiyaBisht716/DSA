package String;

import java.util.*;
public class Operators {
    public static void main(String[] args) {
        System.out.println( 'a'+ 'b'); // 97+98 =195
        System.out.println( "a"+ "b");// contatenate (ab)
        System.out.println((char)('a'+ 2)); //99(c)
        System.out.println("a" + 1);
        //This is same as after a few steps: "a" + "1"
        //integer will converted to Integer that will call toString()
        System.out.println( "Riya" + new ArrayList<>());
    }
}
