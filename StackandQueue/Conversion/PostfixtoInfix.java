package StackandQueue.Conversion;
import java.util.*;
public class PostfixtoInfix {

    //Time Complexity: O(n), a single pass over the postfix expression.

//Space Complexity: O(n), stack space for storing operands.
    // Function to convert postfix to infix
    public static String postfixToInfix(String s){
        Stack<String> st = new Stack<>();
// Traverse the postfix expression from left to right
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
// If the character is an operand, push it to the stack
            if(Character.isLetterOrDigit(c)){
                st.push(String.valueOf(c));
            }
            else{
                 // Pop two operands from the stack
                String op1 = st.pop();
                String op2 =  st.pop();

                 // Form the new infix expression and push back to stack
                st.push("(" + op1 + c + op2 + ")");
            }
        }
        // The final element in the stack is the result
        return st.peek();

    }

    public static void main(String[] args) {
        
        String postfix = "AB*C+";
        System.out.println("Infix Expression: " +postfixToInfix(postfix));
    }
}
