package LinkedList.SinglyLinkedList;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class ReverseLL2 {
       // Function to print the linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Time Complexity:- O(2N) , Space Complexity:- O(1) 
    private static ListNode rotateRight(ListNode head , int k){
        //agar list empty ya k is value 0 ho
        if(head == null || k ==0) return head;

        ListNode tail = head;
        int len = 1;
        while(tail.next != null){
            tail = tail.next;
            len++;
        }

        if(k % len == 0) return head; // agar k multiple of length of toh same list return kr do 
        k = k % len; // handle large values of k

        tail.next = head;
        ListNode newNode = getkthNode(head, len-k); // for left rotate just do (head, k)
        head = newNode.next; // update the head
        newNode.next = null;

        return head;
    }

    private static ListNode getkthNode(ListNode temp , int k){
        int cnt = 1;
        while(temp != null){
            if(cnt == k) return temp;
            temp = temp.next;
            cnt++;
        }
        return temp;
    }
    public static void main(String [] args){
        // Creating linked list: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        System.out.print("Before Rotation: ");
        printList(head);

        head = rotateRight(head, k);
        
        System.out.print("After Rotation: ");
        printList(head);
        
    }
    
}
