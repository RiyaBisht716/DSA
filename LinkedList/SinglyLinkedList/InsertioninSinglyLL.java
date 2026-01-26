package LinkedList.SinglyLinkedList;

class Node {
    int data;
    Node next = null;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
    public Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
};


public class InsertioninSinglyLL {

    private static Node ArrayToLinkedList(int []arr){
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
        Node temp = head;
        while(temp !=null){
            System.out.print(temp.data + " ");
            temp= temp.next;
        }
        System.out.println();
    }

    private static Node insertAtHead(Node head,int data){
        // Node newNode = new Node(data);//called constructor with only data
        // newNode.next = head;
        //Node newNode = new Node(data,head);//called constructor with next node
        return new Node(data,head);


    }
    private static Node insertAtTail(Node head,int data){
        if(head == null) {
            return new Node(data);
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        temp.next = newNode;
        return head;
    }

    private static Node insertAtKth(Node head,int data,int k){
        if(head == null){
            if(k == 1){
                return new Node(data);

            }
        }

        if(k == 1){
            //return new Node(data,head);
            Node newNode = new Node(data);
            newNode.next = head;
            return newNode;

        }

        int cnt =0;
        Node temp = head;
        while(temp != null){
            cnt++;
            if(cnt == k-1){  //stop before k
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
            
        }
        return head;


    }

    private static Node insertBeforeValue(Node head,int data,int val){
        if(head == null){ //empty LL hai toh val kaise hogi insert
            return null;
        }

        if(head.data == val){
            //return new Node(data,head);
            Node newNode = new Node(data);
            newNode.next = head;
            return newNode;

        }
        Node temp = head;
        boolean found =false;
        while(temp.next != null){
            if(temp.next.data == val){  //stop before k
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
            
        }
        if(!found) System.out.println("Value " + val + " is not found ");
        return head;


    }
    public static void main(String[] args) {
        int [] arr ={1,2,3,4,5,6,7};
        Node head = ArrayToLinkedList(arr);
        System.out.print("Before : ");
        printList(head);

        head = insertAtHead(head,100);
        head = insertAtTail(head,200);
        head = insertAtKth(head,300,3);
        head = insertBeforeValue(head,400,8);
        System.out.print("After : ");
        printList(head);
        
    }
    
}

