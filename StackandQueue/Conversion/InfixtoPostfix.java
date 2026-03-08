package StackandQueue.Conversion;
import java.util.*;
public class InfixtoPostfix {
    public static int prec(char c){
        if(c == '^')
            return 3;
            
        else if(c == '/' || c == '*')
            return 2;
        
        else if(c == '+' || c == '-')
            return 1;
        
        else 
            return -1;
    }

    //Time Complexity: O(N), where N is the length of the infix expression. Each character in the expression is processed once


    //Space Complexity: O(N), where N is the length of the infix expression. The stack can hold at most N operators and parentheses in the worst case.
    public static void infixToPostfix(String s){
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            // agar operand aaye toh

            if(Character.isLetterOrDigit(c)){
                ans.append(c);

            }
            //agar opening bracket aaye
            else if(c == '('){
                st.push(c);
            }
            else if(c == ')'){
                while(st.peek() != '('){
                    ans.append(st.pop());
                }
                st.pop(); // pop kro '(' stack se
            }

            //jab operator aaye toh

            else{
                while(!st.isEmpty() && prec(c) <= prec(st.peek())){
                    ans.append(st.pop());
                }
                st.push(c); // current operator ko push kro
            }
        }

        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        
         System.out.println("Postfix expression: " + ans.toString());  // Output the result

    }


    public static void main(String[] args) {
        String exp = "(p+q)*(m-n)";
        System.out.println("Infix expression: " + exp);
        infixToPostfix(exp);  // Convert the infix expression to postfix
    }
}
