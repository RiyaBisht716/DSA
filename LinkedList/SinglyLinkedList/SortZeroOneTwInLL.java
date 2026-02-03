package LinkedList.SinglyLinkedList;

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
  // LinkedList class to manage list operations
class LinkedList {
    ListNode head;

    // Constructor to initialize an empty list
    LinkedList() {
        head = null;
    }

    // Function to insert a new node at the end
    void insert(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode; 
            return;
        }
        ListNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // Function to print the entire linked list
    static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println(" -> NULL");
    }

    // Function to sort linked list of 0s, 1s, and 2s by rearranging the links
   static void sortZeroOneTwo(LinkedList l1) {
        // Create dummy nodes for 0s, 1s, and 2s
        ListNode zeroDummy = new ListNode(-1);
        ListNode oneDummy = new ListNode(-1);
        ListNode twoDummy = new ListNode(-1);

        // Create tail pointers to add new nodes in respective lists
        ListNode zeroTail = zeroDummy;
        ListNode twoTail = twoDummy;
        ListNode oneTail = oneDummy;

        ListNode curr = l1.head;

        // Traverse the original list
        while (curr != null) {
            if (curr.data == 0) {
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            } else if (curr.data == 1) {
                oneTail.next = curr;
                oneTail = oneTail.next;
            } else {
                twoTail.next = curr;
                twoTail = twoTail.next;
            }
            curr = curr.next;
        }

        // Connect 0s list to 1s, and 1s to 2s
        zeroTail.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        oneTail.next = twoDummy.next;
        twoTail.next = null;

        // Update original list head
        l1.head = zeroDummy.next;
    }
}
public class SortZeroOneTwInLL {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();

        l1.insert(1);
        l1.insert(2);
        l1.insert(0);
        l1.insert(1);
        l1.insert(2);
        l1.insert(0);

        System.out.println("Original List:");
        LinkedList.printList(l1.head);
        
        LinkedList.sortZeroOneTwo(l1);

        System.out.println("Sorted List:");
        
        LinkedList.printList(l1.head);
    }
}
