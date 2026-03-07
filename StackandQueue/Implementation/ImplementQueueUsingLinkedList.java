package StackandQueue.Implementation;

// Node structure
class Node {
    int val;
    Node next;
    Node(int d) {
        val = d;
        next = null;
    }
}

// Structure to represent queue
class LinkedListQueue {
    private Node start; // Start of the queue
    private Node end; // End of the queue
    private int size; // Size of the queue

    // Constructor
    public LinkedListQueue() {
        start = end = null;
        size = 0;
    }

    // Time Complexity :- O(1) and Space Complexity : O(n)

    public void push(int x){
        Node newNode = new Node(x);

        //agar first element push kr rhe ho toh
        if(start == null){
            start = end = newNode;

        }
        else{
            end.next = newNode;
            end = newNode;// updating the end
        }

        size++;
    }

    //to remove the element 
    public int pop(){
        if(start == null){
            return -1;

        }

        int value = start.val;
        Node temp = start;
        start = start.next;
        temp = null;
        size--;

        return value;
    }
     // Method to get the front element in the queue
    public int peek() {
        // If the queue is empty
        if (start == null) {
            return -1; // Front element cannot be accessed
        }
        
        return start.val; // Return the front
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return (size == 0);
    }
}

public class ImplementQueueUsingLinkedList {
    public static void main(String[] args) {
        LinkedListQueue q = new LinkedListQueue();

        q.push(1);
        q.push(20);
        q.push(14);


        System.out.println("Pop: " + q.pop());
        System.out.println("Top: " + q.peek());
    }
}
