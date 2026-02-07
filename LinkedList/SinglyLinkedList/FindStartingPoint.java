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

public class FindStartingPoint {
    // Function to print the linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    // Brute Force  -  Time Complexity- O(N), Space Complexity - O(N)

    static ListNode findStartInLoopBrute(ListNode head){
        HashMap<ListNode, Integer> mpp = new HashMap<>();
        ListNode temp = head;

        while(temp != null){
            if(mpp.containsKey(temp)){
                return temp;

            }
            mpp.put(temp,1); // 
            temp = temp.next;

        }
        return null;// no cycle exist

        
    }
    // %%%%%%%%%%%%%%%% optimal approach-  Tc- O(n), SC- O(1) %%%%%%%%%%%%%%%%
 
    static ListNode findStartInLoop(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        // Traverse while fast and fast.next are not null


        while(fast != null && fast.next != null){
            // Move slow one steps
            slow = slow.next;
            // Move fast two steps
            fast = fast.next.next;
            // If they meet, cycle is present

            if(slow == fast){
                // Reset slow to head
                slow = head;
                // Move both one step to find start of loop
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                  // Return the starting node of loop
                return slow;
            }
        }
        // If no cycle found
        return null;
    }
    public static void main(String [] args){
        // Create nodes
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Create cycle: last node connects to node with value 2
        head.next.next.next.next = head.next;

        ListNode result = findStartInLoop(head);

        if (result != null)
            System.out.println("Cycle starts at node with value: " + result.data);
        else
            System.out.println("No cycle found.");
    }
    
}
