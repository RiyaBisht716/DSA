
package LinkedList.SinglyLinkedList;
import java.util.*;

// Class representing a node in the linked list
class Node {
    int data;
    Node next;

    // Constructor for Node with data and next node
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor for Node with only data (next = null)
    Node(int data1) {
        data = data1;
        next = null;
    }
}



public class RemoveNthNodefromEndOfLL {
    // Function to print the linked list
    static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    //***********************(Brute Force- (TC-O(L) +O(L-N),SC:_ O(1)))****************************

    // Function to delete the Nth node from the end
    static  Node deleteNthNodeFromEnd(Node head, int N) {
        // If list is empty
        if (head == null) {
            return null;
        }

        int cnt = 0;
        Node temp = head;

        // Count total number of nodes
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        // If N equals total nodes → delete head
        if (cnt == N) {
            return head.next;
        }

        // Calculate position from start
        int res = cnt - N;
        temp = head;

        // Traverse to the node before target
        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }

        // Delete the node
        temp.next = temp.next.next;

        return head;
    } // Function to delete the Nth node from the end ######Optimal approach -(TC:- O(L). SC:- O(1))
    // using the optimized two-pointer method
    static  Node deleteFromEnd(Node head, int N) {
        

        // Initialize slow and fast pointers atdummy
        Node slow = head;
        Node fast = head;

        // Move fast pointer N+1 steps ahead to create a gap
        for (int i = 0; i <= N; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Slow is now at node before target → delete target node
        slow.next = slow.next.next;

        // Return updated head
        return head.next;
    }
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int N = 3;

        // Create linked list manually
        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));
        head.next.next.next.next = new Node(arr.get(4));
         // Delete the Nth node from the end
        //head = deleteNthNodefromEnd(head);
        head = deleteFromEnd(head, N);

        // Print the modified linked list
        printLL(head);

    
}
}
