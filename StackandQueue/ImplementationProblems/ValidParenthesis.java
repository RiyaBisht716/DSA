package StackandQueue.ImplementationProblems;
import java.util.*;
public class ValidParenthesis {

    // Time Complexity:- O(N) and Space Complexity :- O(N)

     // Function to check if the input string has valid parentheses
private boolean isValid(String s) {
     Stack<Character> st = new Stack<>();  // Stack to store opening brackets

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);  // Push opening brackets to stack
            else {
                if (st.isEmpty()) return false;  // No matching opening bracket
                char top = st.pop();

                // Check for matching pair
                if ((ch == ')' && top == '(') ||
                    (ch == ']' && top == '[') ||
                    (ch == '}' && top == '{'))
                    continue;
                else
                    return false;
            }
        }
        return st.isEmpty();  // True if all brackets matched
}
    public static void main(String[] args) {
        ValidParenthesis vp = new ValidParenthesis();
        
        String s = "()[{}()]";

        if(vp.isValid(s))
            System.out.println("True");
        else
            System.out.println("False");
    }
}
