package StackandQueue.Implementation;

class Node{
    int data;
    Node next;

    public Node(int d){
        data = d;
        next = null;
    }
}
// Structure to represent stack
class LinkedListStack {
    private Node head; // Top of Stack
    private int size; // Size

    // Constructor
    public LinkedListStack() {
        head = null;
        size = 0;
    }

    public void push(int x){
        //create a node
        Node newNode = new Node(x);
        newNode.next = head;// update pointer
        head = newNode;// update the top

        size++;
    }

    public int pop(){
        //stack empty ho
        if(head == null){
            return -1;
        }

        int value = head.data;

        Node temp = head;
        head = head.next;
        temp = null;
        size--;

        return value;
    }

    public int top(){
        // If the stack is empty
        if(head == null){
            return -1;
        }

        return head.data;//return the top
    }

    public boolean isEmpty(){
        return (size == 0);
    }

}
// Time Complexity :- O(1) and Space Complexity : O(n)

public class ImplementStackUsingLinkedList {
    public static void main(String[] args) {
        LinkedListStack st = new LinkedListStack();

        st.push(1);
        st.push(20);
        st.push(14);


        System.out.println("Pop: " + st.pop());
        System.out.println("Top: " + st.top());
        

    }
}
