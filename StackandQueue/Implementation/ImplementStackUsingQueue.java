package StackandQueue.Implementation;
import java.util.*;
// Stack implementation using Queue
class QueueStack {
    // Queue
    Queue<Integer> q = new LinkedList<>();

    // Method to push element in the stack
    // TC:-O(n) operations
    public void push(int x) {
        // Get size
        int s = q.size();
        // Add element
        q.add(x);

        // Move elements before new element to back
        for (int i = 0; i < s; i++) {
            q.add(q.poll());
        }
    }

    // TC:- O(1)
    // Method to pop element from stack
    public int pop() {
        // Get front element
        int n = q.peek();
        // Remove front element
        q.poll();
        // Return removed element
        return n;
    }

     // TC:- O(1)
    // Method to return the top of stack
    public int top() {
        // Return front element
        return q.peek();
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return q.isEmpty();
    }
}

public class ImplementStackUsingQueue {
    public static void main(String[] args) {
        QueueStack st = new QueueStack();
        
        // Array of commands
        String[] commands = {"QueueStack", "push", "push", "pop", "top", "isEmpty"};
        int[][] inputs = {{}, {4}, {8}, {}, {}, {}};

        for (int i = 0; i < commands.length; ++i) {
            switch (commands[i]) {
                case "push":
                    st.push(inputs[i][0]);
                    System.out.print("null ");
                    break;
                case "pop":
                    System.out.print(st.pop() + " ");
                    break;
                case "top":
                    System.out.print(st.top() + " ");
                    break;
                case "isEmpty":
                    System.out.print(st.isEmpty() ? "true " : "false ");
                    break;
                case "QueueStack":
                    System.out.print("null ");
                    break;
            }
        }
    }
}
