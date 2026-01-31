package LinkedList.SinglyLinkedList;
import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}



public class OddEvenIndexLL {

    // =============[T.C:- O(2N),S.C :- O(N)]*********************
    static ListNode oddEvenListUsingArray(ListNode head){
        if(head == null || head.next == null) return head;

        List<Integer> lst = new ArrayList<>();
        ListNode temp = head;

        //push odd place node.data
        while(temp!= null && temp.next != null){
            lst.add(temp.val);
            temp = temp.next.next;
        }
        //edge case agar Linked list odd hai toh temp last node pr hai woh add nhi karega to usko bhi add kro

        if(temp != null) lst.add(temp.val);

        //push even place node.data
        temp = head.next;
        while(temp != null && temp.next != null){
            lst.add(temp.val);
            temp = temp.next.next;
        }
        //edge case agar Linked list odd hai toh temp last node pr hai woh add nhi karega to usko bhi add kro

        if(temp != null) lst.add(temp.val);
        //Replace the data
        temp = head;
        int i =0;
        while(temp != null){
            temp.val = lst.get(i++);
            temp =temp.next;

        }
        return head;

    }
    // =============[T.C:- O(N),S.C :- O(1)]*********************
    static ListNode OddEvenPlaceNode(ListNode head){
        ListNode odd = head; // start of odd list
        ListNode even = head.next;  // start of even list
        ListNode evenHead = even; // save for later

        while(even != null && even.next != null){
            odd.next = odd.next.next;  // link odd to next odd
            even.next = even.next.next;  // link even to next even

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;// connect end of odd to start of even
        return head;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next =new ListNode(4);

        System.out.print("Before: ");
        printList(head);
        head = OddEvenPlaceNode(head);
        System.out.print("After:  ");
        printList(head);


    }

}
