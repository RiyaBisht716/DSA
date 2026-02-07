package LinkedList.SinglyLinkedList;

import java.util.HashMap;

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

public class DetectLoopInLL {
    // Function to print the linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // function to detect loop in linked list
    //detect loop using hashmap - TC- O(N* logN), SC:- N
    static boolean detectLoopBrute(ListNode head) {
        // Initialize a pointer 'temp'
        // at the head of the linked list
        ListNode temp = head;

        // Create a map to keep track of
        // encountered nodes
        HashMap<ListNode, Integer> nodeMap = new HashMap<>();

        // Step 2: Traverse the linked list
        while (temp != null) {
            // If the node is already in the
            // map, there is a loop
            if (nodeMap.containsKey(temp)) {
                return true;
            }
            // Store the current node
            // in the map
            nodeMap.put(temp, 1);

            // Move to the next node
            temp = temp.next;
        }

        // Step 3: If the list is successfully traversed 
        // without a loop, return false
        return false;
    }
    //check there is loop exist using Tortoise and Hare Algorithm 
    // #################### Optimal Approach:- TC-O(N), SC:- O(1)################

    static boolean detectLoop(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true ;
            }

        }
        return false;

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

    

        // Check if there is a loop 
        // in the linked list
        if (detectLoopBrute(head)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }

        


    }
    
}
