package StackandQueue.Conversion;
import java.util.*;
public class PostfixtoPrefix {

    /*Time Complexity: O(2n), as we traverse the expression only once.

Space Complexity: O(n) for the stack to store operands and intermediate results. */
    public static String postfixToPrefix(String postfix){
        Stack<String> s = new Stack<>();
        int n1 = postfix.length();

        for(int i =0;i<n1;i++){
            char ch = postfix.charAt(i);

            //operand aaya toh add kr do stack mai simply

            if(Character.isLetterOrDigit(ch)){
                s.push(String.valueOf(ch));
            }
            else{
                String op1 = s.pop(); // 1st pop
                String op2 = s.pop(); // 2nd pop


                s.push(ch + op2 + op1);
            }


        }
        return s.peek();


    }



    public static void main(String[] args) {
        String postfix = "ABC/-AK/L-*";

        System.out.println("Prefix: " +postfixToPrefix(postfix));

    }
}
