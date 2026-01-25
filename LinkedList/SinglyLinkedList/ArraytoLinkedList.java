package LinkedList.SinglyLinkedList;

//Time Complexity: - O(N)

class Node{
    int data;
    Node next;

    //constructor 
    public Node(int data1){
        this.data = data1;
        this.next = null;
    }
}
public class ArraytoLinkedList {
    private static Node convertArr2LL(int[]arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    
    }
    private static void printList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+ " ");
            curr = curr.next;

        }
        System.out.println("\n");


    }
    private static void findLength(Node head){
        int cnt =0;
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
            cnt++;
        }
        System.out.println("Length is : " + cnt);

    }
    private static void search(Node head,int value){
        Node curr = head;
        boolean found = false;
        while(curr != null){
            if(curr.data == value){
                found = true;
                break;
            }
            curr = curr.next;
        }
        if(found){
            System.out.println("Found : " + value);
        }
        else{
            System.out.println("Not Found: " + value);
        }
            System.out.println("\n");

    }
    

    public static void main(String[] args) {
        int[]arr = {12,5,8,7};
        Node head = convertArr2LL(arr);

        //System.out.print(head.data);
        
        //Traversal in LL
        findLength(head);
        printList(head);
        int value = 5;
        search(head,value);
    }
}
