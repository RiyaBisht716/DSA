package StackandQueue.Conversion;
import java.util.*;
public class PrefixtoInfix {

    /*Time Complexity: O(2n) where n is the length of the prefix expression (only one pass).

Space Complexity: O(n) for the stack used to store operands.*/


    public static  String prefixToInfix(String prefix){
        Stack<String> s = new Stack<>();

        int n = prefix.length();
 // peche se start hoga 
        for(int i = n-1;i>=0;i--){
            char c = prefix.charAt(i);
            // operand add kro
            if(Character.isLetterOrDigit(c)){
                s.push(String.valueOf(c));
            }
            else{

                //agar operator ho toh
                String op1 = s.pop();
                String op2 = s.pop();

                s.push("(" + op1 + c + op2 + ")");
            }


        }
        //top element print kra do
        return s.peek();
    }

    public static void main(String[] args) {
        String prefix = "*-A/BC-/AKL";

        System.out.println("Infix Expression: " +prefixToInfix(prefix));
    }
}
