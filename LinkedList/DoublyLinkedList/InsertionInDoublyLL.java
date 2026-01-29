package LinkedList.DoublyLinkedList;
class Node{
    int data;
    Node next;
    Node prev;

    public Node(int data1,Node next1,Node prev1){
        this.data = data1;
        this.next = next1;
        this.prev = prev1;

    }
    public Node(int data1){
        this.data = data1;
        this.next = null;
        this.prev = null;
    }
    
}

public class InsertionInDoublyLL {

    private static Node ArrayToDoublyLL(int[]num){
        Node head = new Node(num[0]);
        Node prev = head;
        for(int i=1;i<num.length;i++){
            Node temp = new Node(num[i],null,prev);
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

    private static Node InsertBeforeHead(Node head,int val){
        Node newHead = new Node(val,head,null);
        head.prev = newHead;

        return newHead;


    }
    private static Node InsertBeforeTail(Node head,int val){
        //agar single node hai toh 

        if(head == null) return InsertBeforeHead(head,val);

        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        Node prev = tail.prev;
        Node newNode = new Node(val,tail,prev);
        prev.next = newNode;
        tail.prev = newNode;

        return head;


    }

    private static Node InsertBeforeKthElement(Node head,int k,int val){
        //agar sirf ek element ho 
        if(k == 1){
            return InsertBeforeHead(head,val);
        }

        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt ++;
            if(cnt == k) break;
            temp = temp.next;
        }
        Node prev = temp.prev;
        Node newNode = new Node(val,temp,prev);
        prev.next = newNode;
        temp.prev = newNode;

        return head; 
    }

    private static void InsertBeforeNode(Node temp,int val){
        Node prev = temp.prev;
        Node newNode = new Node(val,temp,prev);
        prev.next = newNode;
        temp.prev = newNode;
    }

    public static void main(String[]args){
        int[] arr = {1,2,3,4,5,6};
        Node head = ArrayToDoublyLL(arr);
        // head = InsertBeforeHead(head,10);
        // head = InsertBeforeTail(head,12);
        // head = InsertBeforeKthElement(head,2,11);
        InsertBeforeNode(head.next,100);
    
        printList(head);


    }
    
}
