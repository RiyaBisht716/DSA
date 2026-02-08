package LinkedList.DoublyLinkedList;
class ListNode{
    int data;
    ListNode next;
    ListNode prev;

    public ListNode(int data1,ListNode next1,ListNode prev1){
        this.data = data1;
        this.next = next1;
        this.prev = prev1;

    }
    public ListNode(int data1){
        this.data = data1;
        this.next = null;
        this.prev = null;
    }
    
}

public class DeleteAllOccurenceOfKey {
    private static void printList(ListNode head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static ListNode deleteAllOccurenceOfKey(ListNode head, int key){
        ListNode temp = head;

        while(temp != null){
            if(temp.data == key ){
                //agar head he delete krna ho toh usko pahele update kro
                if(temp == head){
                    head = temp.next;
                }

                ListNode nextNode = temp.next;
                ListNode prevNode = temp.prev;

                if(nextNode != null) nextNode.prev = prevNode;

                if(prevNode != null) prevNode.next = nextNode;
                
                temp = nextNode;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(30);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(10);
        ListNode fifth = new ListNode(40);
        ListNode sixth = new ListNode(30);
        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;
        fourth.next = fifth;
        fifth.prev = fourth;
        fifth.next = sixth;
        sixth.prev = fifth;
        int key = 30;

        System.out.print("Before Deletion: ");
        printList(head);

        head = deleteAllOccurenceOfKey(head,key);

        System.out.print("After Deletion: ");
        printList(head);

    }

    
}
