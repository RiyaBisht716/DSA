package LinkedList;

class Node {
    int data;
    Node next;

    //constructor
    Node(int data1,Node next1){
        this.data = data1;
        this.next = next1;

    }
    Node(int data1){
        this.data = data1;
        this.next = null;

    }

    
};
public class CreatingNode{
    public static void main(String[] args) {
        int [] arr = {2,5,6,8};
        //create first node
        Node head = new Node(arr[0]);
        //print memory reference of node
        System.out.print(head);
        //print the data stored in node
        System.out.print(head.data);
    }

}

