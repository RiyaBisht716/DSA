package LinkedList.SinglyLinkedList;
import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class MergeTwoList {
     // Function to print the linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Function to convert an array to a linked list
    static ListNode convertArrToLinkedList(ArrayList<Integer> arr) {
        // Create a dummy node to serve
        // as the head of the linked list
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        // Iterate through the array and
        // create nodes with array elements
        for (int i = 0; i < arr.size(); i++) {
            // Create a new node with the array element
            temp.next = new ListNode(arr.get(i));
            // Move the temporary pointer to the newly created node
            temp = temp.next;
        }
        // Return the linked list starting
        // from the next of the dummy node
        return dummyNode.next;
    }

    // $$$$$$$$$$$$$ Brute Force Time complexity:- O(nlogn) + O(n1 + n2) , Sc:-O(N) $$$$$$$$$$$$$$

    // Function to merge two sorted linked lists
    static ListNode sortTwoLinkedLists(ListNode head1, ListNode head2) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        // Storing elements of both lists into an array
        
        // Add elements from list1 to the array
        while (temp1 != null) {
            arr.add(temp1.val);
            // Move to the next node in list1
            temp1 = temp1.next;
        }

        // Add elements from list2 to the array
        while (temp2 != null) {
            arr.add(temp2.val);
            // Move to the next node in list2
            temp2 = temp2.next;
        }

        // Sorting the array in ascending order
        Collections.sort(arr);
    

        // Converting the sorted array
        // back to a linked list
        ListNode head = convertArrToLinkedList(arr);

        // Return the head of the
        // merged sorted linked list
        return head;
    }

    // ################ Optimal Time complexity:- O(n1 + n2), space Complexity:- O(1) ###################

    private static ListNode mergeTwoList(ListNode head1, ListNode head2){
        ListNode t1 = head1;// list 1 values
        ListNode t2 = head2;//list 2 values
        ListNode dummy = new ListNode(-1);// dummyNode 
        ListNode temp = dummy;

        while(t1 != null && t2 != null){
            //agar t1 ki value choti hoyi toh 
            //dummy ke next ko t1 se connect kr do
            if(t1.val<t2.val){
                temp.next = t1;
                temp = t1;
                t1 = t1.next;

            }
            //t2 se connect kr do
            else{
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }
        //abhi bhi t1 mai values bachi hai
        if(t1 != null) temp.next = t1;
        //abhi bhi t2 mai values bachi hai
        else temp.next = t2;

        //dummy ka next return kr do joh head hai
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example Linked Lists
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

        System.out.print("First sorted linked list: ");
        printList(head1);

        System.out.print("Second sorted linked list: ");
        printList(head2);

        //ListNode mergedList =  mergeTwoList(head1, head2);
        ListNode mergedList2 =  sortTwoLinkedLists(head1, head2);


        System.out.print("Merged sorted linked list: ");
        //printList(mergedList);
        printList(mergedList2);
    }
    
}

