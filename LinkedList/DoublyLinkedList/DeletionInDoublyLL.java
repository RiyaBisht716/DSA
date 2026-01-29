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

public class DeletionInDoublyLL {

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

    private static Node DeletionAtHead(Node head){
        if(head == null || head.next == null)
        return null;

        Node prev = head;
        head = head.next;//ismai head aage badh gya second node pe
        head.prev = null; //aab head ke prev ko null kr diya 
        prev.next = null; // prev jismai head hai uske next ko null kr diya taki connection toth jaye

        return head;
    }

    private static Node DeletionAtTail(Node head){
        //handle the empty and only single node
        if(head == null || head.next ==  null)
        return null;

        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        Node newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;

        return head;
    }

    private static Node DeletionAtKth(Node head, int k){
        //empty Linked list
        if(head == null){
            return null;
        }
        

        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            if(cnt == k) break;
            temp = temp.next;
        }
        //agar k out of bound hai toh
        if(temp == null) return head;

        
        //agar sirf ek node he
        if(temp.prev == null && temp.next == null){
            return null;

        }
        //agar kth node head ho
        else if(temp.prev == null){
            return DeletionAtHead(head);
        }
        //agar kth node tail ho
        else if(temp.next == null){
            return DeletionAtTail(head);
        }
        Node prev = temp.prev;
        Node next = temp.next;

        prev.next = next;
        next.prev = prev;
        temp.next = null;
        temp.prev = null;

        return head;
    }
    
    private static void DeleteNode(Node temp){
        Node prev = temp.prev;
        Node front = temp.next;

        //agar last node ko delete krna ho

        if(front == null){
            prev.next = null;
            temp.prev = null;
            return;
        }

        prev.next = front;
        front.prev = prev;
        temp.next = temp.prev = null;

    }


    
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        Node head = ArrayToDoublyLL(num);
        System.out.print("Before Deletion : ");
        printList(head);
        head = DeletionAtHead(head);
        head = DeletionAtTail(head);
        head = DeletionAtKth(head, 3);
        DeleteNode(head.next);//yaha head ko delete nhi krenge kyuki usmai fir or constraint lagega head ko change krna padega isliye hamesha head ke next ko he delete karenge
        System.out.print("After Deletion : ");
        printList(head);

    }
    
}
