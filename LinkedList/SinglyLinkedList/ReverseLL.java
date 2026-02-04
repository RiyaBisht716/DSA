package LinkedList.SinglyLinkedList;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class ReverseLL {

    // Function to print the linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    

    // ############# Reverse Linked List using stack ###########
    //############## Brute Force (TC:- O(N), SC:- O(1)) ############### 
     // Function to reverse a linked list using stack
    static ListNode reverseListUsingStack(ListNode head) {
        // Stack to store values of nodes
        Stack<Integer> stack = new Stack<>();

        // Temporary pointer to traverse the list
        ListNode temp = head;

        // Traverse and push all node values to stack
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        // Reset temp back to head
        temp = head;

        // Reassign values from stack in reverse order
        while (temp != null) {
            temp.val = stack.pop();
            temp = temp.next;
        }

        // Return the modified head
        return head;
    }
    // ############### Reverse LlinkedList iterative solution
    // Function to reverse a linked list iteratively
    static ListNode reverseListIterative(ListNode head) {
        // Initialize previous pointer to null
        ListNode prev = null;

        // Start from the head of the list
        ListNode temp = head;

        // Traverse the list
        while (temp != null) {
            // Save the next node
            ListNode front = temp.next;

            // Reverse the current node's pointer
            temp.next = prev;

            // Move prev to current node
            prev = temp;

            // Move to the next node
            temp = front;
        }

        // Return new head (last node becomes first)
        return prev;
    }
    // $$$$$$$$$$$$$$$ (TC:- O(N), SC:- O(n), wher n is recursion stack) $$$$$$$$$$$$$$$$$w
    static ListNode reverseLLRecursion(ListNode head){
        //base case where we have to stop

        if(head == null || head.next == null) return head;

        ListNode newHead = reverseLLRecursion(head.next);//calling recursion for n nodes
        // Store reference to next node
        ListNode front = head.next;
        
        // Make the next node point to current node
        front.next = head;
        // Break original forward link
        head.next = null;

         // Return new head of reversed list
        return newHead;
    }
    public static void main(String [] args){
        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.print("Before Reversed : ");
        printList(head);


        //head =reverseListIterative(head);
        //
        //head = reverseListUsingStack(head);
        head = reverseLLRecursion(head);

        System.out.print("After Reversed : ");
        printList(head);

    }


    
}
