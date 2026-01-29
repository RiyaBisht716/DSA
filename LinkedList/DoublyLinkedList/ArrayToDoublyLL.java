package LinkedList.DoublyLinkedList;

class Node{
    int data;
    Node next;
    Node prev;

    //constructor with dat,next and prev
    public Node(int data1,Node next1,Node prev1){
        this.data = data1;
        this.next = next1;
        this.prev = prev1;
    }
    //constructor with data only

    public Node(int data1){
        this.data = data1;
        this.next = null;
        this.prev = null;
    }
}

public class ArrayToDoublyLL {

    private static Node ArrayToDoublyLL(int[]arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;
            prev = temp;

        }
        return head;
    }

    private static void printList(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[]arr ={1,2,3,4,5};
        Node head = ArrayToDoublyLL(arr);
        printList(head);
        
    }
    
}
