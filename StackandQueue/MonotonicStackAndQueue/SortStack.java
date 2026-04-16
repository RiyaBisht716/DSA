package StackandQueue.MonotonicStackAndQueue;
import java.util.*;


class Solution{

    //Time Complexity: O(n2), where n is the number of elements in the stack.

     //Space Complexity: O(n), due to the recursion stack.
    // yeh function elment ko correct order mai place krne ko hai soted order mai in decreasing order
    public void insert(Stack<Integer> st , int temp){
        //base condition
        if(st.isEmpty() || st.peek() <= temp){
            st.push(temp);
            return;
        }

        int var = st.pop();
        //calling fuction for next element
        insert(st,temp);

        //push the popp element back into the stack

        st.push(var);
    }
    // yeh function element ko pop kr rha hai

    public void sortStack(Stack<Integer> st){

        if(!st.isEmpty()){
            int temp = st.pop();
            sortStack(st);
            insert(st, temp);

        }
    }
}


public class SortStack {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(1);
        st.push(3);
        st.push(2);

        sol.sortStack(st);

        //print the result 
        System.out.print("Sort in descending order: ");
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
    }
    
}
