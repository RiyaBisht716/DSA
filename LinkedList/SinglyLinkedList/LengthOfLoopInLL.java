package LinkedList.SinglyLinkedList;
import java.util.*;
class ListNode {
    int data ;
    ListNode next;

    public ListNode(int data1 , ListNode next1){
        this.data = data1;
        this.next = next1;

    }
    
    public ListNode(int data1){
        this.data = data1;
        this.next = null;
        
    }
}

public class LengthOfLoopInLL {
     // Function to print the linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // ############# Brute Force :- Tc-(O(N)) , SC :- O(N) ###############
    static int lengthOfLoop(ListNode head){
        ListNode temp = head;
        int timer = 0;

        HashMap<ListNode, Integer> map = new HashMap<>();

        while(temp != null){
            if(map.containsKey(temp)){
                int loopLength = timer - map.get(temp);
                return loopLength;

            }
            map.put(temp,timer);
            temp = temp.next;
            timer++;
    }
    return 0;
    
}
// ########### Optimal Approach - TC- O(N), SC:- O(1) ######
static int LengthOfLoop(ListNode head){
    ListNode slow = head;
    ListNode fast = head;
    
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            return findlength(slow,fast);
        }
    }
    return 0;
}
static int findlength(ListNode slow, ListNode fast){
    int cnt = 1;
    fast = fast.next;

    while(slow != fast){
        cnt++;
        fast = fast.next;
    }
    return cnt;

}

public static void main(String[] args){
    
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new  ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new  ListNode(5);
        

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;

        // Getting the loop length
        int loopLength = lengthOfLoop(head);

        // Printing the result
        if (loopLength > 0) {
            System.out.println("Length of the loop: " + loopLength); 
        } else {
            System.out.println("No loop found in the linked list.");
        }

    
}
}
