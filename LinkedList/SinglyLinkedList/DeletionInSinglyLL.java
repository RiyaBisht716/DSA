package LinkedList.SinglyLinkedList;

class Node{
    int data;
    Node next;

    public Node(int d){
        this.data = d;
        this.next = null;

    }
}


public class DeletionInSinglyLL {

    private static Node ArraytoSinglyLL(int[]arr){
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
        Node  curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();


    }
    private static Node deleteAtHead(Node head){
        if(head == null) return head; //edge case when LL is empty
        Node temp = head;
        head = head.next;
        temp = null; // ya isko nhi bhi likh sakte hai kyuki java mai garbage collector hota hai

        return head;

    }

    private static Node deleteAtTail(Node head){
        if(head == null || head.next == null) return null;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    private static Node deleteAtKthPosition(Node head,int k){
        if(head == null) return head;

        if(k == 1){
            Node temp = head;
            head = head.next;
            temp = null;
            return head;

        }

        int cnt = 0;
        Node temp = head;
        Node prev = null;

        while(temp != null){
            cnt++;

            if(cnt == k){
                prev.next = prev.next.next;
                temp = null;
                break;
            }
            prev = temp;
            temp = temp.next;
            
        }
        return head;
        
    }
    private static Node deleteAtValue(Node head,int val){
        if(head == null) return head;

        if(head.data == val){
            Node temp = head;
            head = head.next;
            temp = null;
            return head;

        }

        int cnt = 0;
        Node temp = head;
        Node prev = null;

        while(temp != null){
            

            if(head.data == val){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
            
        }
        return head;
        
    }



    public static void main(String[] args) {
        int[]arr = {1,2,5,6,7,9,10,11,12,13};
        Node head = ArraytoSinglyLL(arr);
        System.out.println("Before Deletion: ");
        printList(head);

        head = deleteAtHead(head);
        head = deleteAtTail(head);
        head = deleteAtKthPosition(head,2);
        head = deleteAtValue(head,5);
        System.out.println("Before Deletion: ");
        printList(head);
        


        
    }
    
}
