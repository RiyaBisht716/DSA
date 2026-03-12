package StackandQueue.Conversion;
import java.util.*;
public class PrefixtoPost {

    /*Time Complexity: O(n), single pass through the expression.

Space Complexity: O(n), stack space for storing intermediate results.*/
    public static String prefixToPost(String prefix){
        Stack<String> s = new Stack<>();

        int num = prefix.length();

        for(int i = num -1;i>=0;i--){
            char c = prefix.charAt(i);

            if(Character.isLetterOrDigit(c)){
                s.push(String.valueOf(c));
            }
            else{
                String op1 = s.pop();
                String op2 = s.pop();


                s.push(op1 + op2 + c);
            }

        }
        return s.peek();

    }

    public static void main(String[] args) {
        String prefix = "*-A/BC-/AKL";
        System.out.println("Postfix Expression: " +prefixToPost(prefix));
    }
}
