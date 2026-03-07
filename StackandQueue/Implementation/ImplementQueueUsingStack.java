package StackandQueue.Implementation;
import java.util.*;

class StackQueue{
    Stack<Integer> st1,st2;

    //constructor
    public StackQueue(){
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    //    ######### Approach-2 :- Using Two stack where push operation is O(1) Time Complexity;- push- O(1), pop and top - O(n) and Space Complexity:-O(n) for storing the element in stack

    // Take O(1) operations
    public void push(int x){
        st1.push(x);
    }
    // Take O(n) operations

    public int pop(){
        if(!st2.isEmpty()){
            return st2.pop();
        }
        else{
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }
// Take O(n) operations
    public int peek(){
        if(!st2.isEmpty()){
            return st2.peek();
        }
        else{
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }
    public boolean isEmpty() {
        return st1.isEmpty() && st2.isEmpty();
    }


}

public class ImplementQueueUsingStack {
    public static void main(String[] args) {
        StackQueue q = new StackQueue();
        q.push(3);
        q.push(4);
        System.out.println("The element popped is " + q.pop());
        q.push(5);
        System.out.println("The front of the queue is " + q.peek());
        System.out.println("Is the queue empty? " + (q.isEmpty() ? "Yes" : "No"));
        System.out.println("The element popped is " + q.pop());
        System.out.println("The element popped is " + q.pop());
        System.out.println("Is the queue empty? " + (q.isEmpty() ? "Yes" : "No"));
    }
}
